package com.example.demo.service;

import com.example.demo.entity.SensorReading;
import java.util.List;
import java.util.Optional;

public interface SensorReadingService {
    SensorReading save(SensorReading reading);
    List<SensorReading> findAll();
    Optional<SensorReading> findById(Long id);
}
