package com.example.weather.service;
import com.example.weather.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;
@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    // <-- Put your real OpenWeatherMap API key here
    private final String API_KEY = "bdb3317a518876487846536b7b0cc749";

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Weather fetchAndSaveWeather(String city) {

        // Build the URL to call OpenWeatherMap API
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city +
                "&appid=" + API_KEY +
                "&units=metric";

        // Make the HTTP request
        Map response = restTemplate.getForObject(url, Map.class);

        // Safety check: if API fails or returns invalid data
        if (response == null || response.get("main") == null) {
            throw new RuntimeException("Weather API error: " + response);
        }

        // Extract temperature and humidity
        Map main = (Map) response.get("main");
        double temperature = Double.parseDouble(main.get("temp").toString());
        int humidity = Integer.parseInt(main.get("humidity").toString());

        // Create Weather entity
        Weather weather = new Weather();
        weather.setCity(city);
        weather.setTemperature(temperature);
        weather.setHumidity(humidity);
        weather.setFetchedAt(LocalDateTime.now());

        // Save to MySQL database
        return weatherRepository.save(weather);
    }
}
