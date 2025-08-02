/* Q2. Weather Forecast Application
Integrate an external API to fetch real-time weather data for a given location and display it in a user-friendly interface. */
package com.weather_forecast_application;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            WeatherService service = new WeatherService();
            SearchHistoryManager history = new SearchHistoryManager();
            history.showHistory();
            String city = null;
            while (true) {
                System.out.print("\nChoose input method (1: Text, 2: Voice): ");
                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter 1 or 2.");
                    continue;
                }
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter city: ");
                        city = scanner.nextLine().trim();
                    }
                    case 2 -> {
                        city = VoiceInput.getCityNameByVoice();
                        if (city == null) {
                            System.out.println("Voice input failed. Try again.");
                            continue;
                        }
                    }
                    default -> {
                        System.out.println("Invalid choice. Enter 1 or 2.");
                        continue;
                    }
                }
                if (!WeatherService.isValidCity(city)) {
                    System.out.println("Invalid city. Please check the name and try again.");
                    System.out.print("Do you want to try again? (yes/no): ");
                    String retry = scanner.nextLine().trim().toLowerCase();
                    if (!retry.equals("yes")) {
                        System.out.println("Exiting. Goodbye!");
                        return;
                    }
                } else {
                    break;
                }
            }
            history.save(city);
            try {
                // Current weather
                WeatherData current = service.getCurrentWeather(city);
                System.out.println("\nCurrent Weather in " + current.getCity() + ":");
                System.out.println("Condition: " + current.getDescription());
                System.out.println("Temperature: " + current.getTemperature() + "°C");
                // 5-day forecast
                System.out.println("\n5-Day Forecast:");
                Map<String, List<WeatherData>> groupedForecast = service.getFiveDayForecastGrouped(city);
                for (String date : groupedForecast.keySet()) {
                    System.out.println("\nDate: " + date);
                    for (WeatherData data : groupedForecast.get(date)) {
                        System.out.printf("%s - %s - %.1f°C\n",
                                data.getDateTime(), data.getDescription(), data.getTemperature());
                    }
                }
            } catch (Exception e) {
                System.out.println("Failed to fetch data. Check internet or API limits.");
            }
        }
    }
}