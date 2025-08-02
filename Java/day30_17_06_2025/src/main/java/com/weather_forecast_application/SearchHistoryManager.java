package com.weather_forecast_application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SearchHistoryManager {
    private static final String FILE_NAME = "search_history.txt";
    public void save(String city) {
        try {
            Set<String> cities = new HashSet<>(loadHistory());
            cities.add(city);
            try (FileWriter writer = new FileWriter(FILE_NAME)) {
                for (String c : cities) {
                    writer.write(c + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving search history.");
        }
    }
    public List<String> loadHistory() {
        List<String> history = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                history.add(scanner.nextLine());
            }
        } catch (FileNotFoundException ignored) {}
        return history;
    }
    public void showHistory() {
        List<String> history = loadHistory();
        if (history.isEmpty()) {
            System.out.println("No previous city searches found.");
        } else {
            System.out.println("\nPrevious Searches:");
            for (String city : history) {
                System.out.println("- " + city);
            }
        }
    }
}