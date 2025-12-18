package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Sensor{
    @Id
    private Long id;
    @column(unique=true)
    private String sensorCode;
    private String sensorType;
    private String location;
    private LocalDateTime installedAt;
    private Boolean isActive;

    
    
}