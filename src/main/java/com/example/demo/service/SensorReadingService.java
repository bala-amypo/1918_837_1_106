package com.example.demo.service;

import com.example.demo.entity.SensorReading;
import java.util.List;
import java.util.Optional;

public interface SensorReadingService {
    SensorReading save(SensorReading reading);
    List<SensorReading> getReadingsBySensor(Long sensorId);
    Optional<SensorReading> getReading(Long readingId);
    void submitReading(Long sensorId, SensorReading reading);
}
