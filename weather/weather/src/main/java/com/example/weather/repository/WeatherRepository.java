package com.example.weather.repository;
import com.example.weather.entity.Weather;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

}
