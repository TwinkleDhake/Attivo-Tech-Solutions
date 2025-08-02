package com.weather_forecast_application;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.hc.client5.http.fluent.Request;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherService {
    private static final String API_KEY = "12002d83d7fefc3d1c0e04c63dfcb416";
    public WeatherData getCurrentWeather(String city) throws Exception {
        try {
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            String url = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                encodedCity, API_KEY
            );
            String response = Request.get(url).execute().returnContent().asString();
            JsonObject json = JsonParser.parseString(response).getAsJsonObject();
            double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
            String desc = json.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
            return new WeatherData(city, "Now", desc, temp);
        } catch (IOException e) {
            throw new Exception("Unable to fetch current weather. Please check the city name or internet.");
        }
    }
    public Map<String, List<WeatherData>> getFiveDayForecastGrouped(String city) throws Exception {
        try {
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            String url = String.format(
                "https://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric",
                encodedCity, API_KEY
            );
            String response = Request.get(url).execute().returnContent().asString();
            JsonObject json = JsonParser.parseString(response).getAsJsonObject();
            JsonArray list = json.getAsJsonArray("list");
            Map<String, List<WeatherData>> forecastMap = new LinkedHashMap<>();
            for (JsonElement element : list) {
                JsonObject obj = element.getAsJsonObject();
                String dateTime = obj.get("dt_txt").getAsString();
                String date = dateTime.split(" ")[0];
                double temp = obj.getAsJsonObject("main").get("temp").getAsDouble();
                String desc = obj.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
                WeatherData data = new WeatherData(city, dateTime, desc, temp);
                forecastMap.computeIfAbsent(date, _ -> new ArrayList<>()).add(data);
            }
            return forecastMap;
        } catch (IOException e) {
            throw new Exception("Unable to fetch forecast. Please check the city name or internet.");
        }
    }
    public static boolean isValidCity(String city) {
        try {
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            String url = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                encodedCity, API_KEY
            );
            Request.get(url).execute().returnContent().asString();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}