package com.weather_forecast_application;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

public class VoiceInput {
    public static String getCityNameByVoice() {
        try {
            Configuration config = new Configuration();
            config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            config.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
            config.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(config);
            recognizer.startRecognition(true);
            System.out.println("🎤 Speak the city name (listening...):");
            String utterance = recognizer.getResult().getHypothesis();
            recognizer.stopRecognition();
            if (utterance != null && !utterance.trim().isEmpty()) {
                System.out.println("You said: " + utterance);
                return utterance;
            } else {
                System.out.println("Could not understand. Please try text input instead.");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Voice input failed due to error: " + e.getMessage());
            return null;
        }
    }
}