package com.example.weather.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String   city;
    private double  temperature;
    private int humidity;
    private LocalDateTime fetchedAt;
}
