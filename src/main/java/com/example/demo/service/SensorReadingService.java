package com.example.demo.service;

import com.example.demo.entity.SensorReading;
import java.util.List;

public interface SensorReadingService {
    SensorReading save(SensorReading reading);
    List<SensorReading> findAll();
}
