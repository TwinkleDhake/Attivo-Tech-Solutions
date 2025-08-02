package com.weather_forecast_application;

public class WeatherData {
    private final String city;
    private final String dateTime;
    private final String description;
    private final double temperature;
    public WeatherData(String city, String dateTime, String description, double temperature) {
        this.city = city;
        this.dateTime = dateTime;
        this.description = description;
        this.temperature = temperature;
    }
    public String getCity() {
        return city;
    }
    public String getDateTime() {
        return dateTime;
    }
    public String getDescription() {
        return description;
    }
    public double getTemperature() {
        return temperature;
    }
}