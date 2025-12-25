package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;
public interface SensorReadingService {
    SensorReading submitReading(Long sensorId, SensorReading r);
    SensorReading getReading(Long id);
    List<SensorReading> getReadingsBySensor(Long sensorId);
}
