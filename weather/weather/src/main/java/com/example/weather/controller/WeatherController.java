package com.example.weather.controller;

import com.example.weather.entity.Weather;
import com.example.weather.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Endpoint: GET /weather?city=London
    @GetMapping
    public Weather getWeather(@RequestParam String city) {
        return weatherService.fetchAndSaveWeather(city);
    }
}
