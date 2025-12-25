package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorReadingService;

import java.time.LocalDateTime;
import java.util.List;

public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository readingRepository;
    private final SensorRepository sensorRepository;

    public SensorReadingServiceImpl(SensorReadingRepository readingRepository,
                                    SensorRepository sensorRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
    }

    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor not found"));

        if (reading.getReadingValue() == null || reading.getReadingValue() == 0) {
            throw new IllegalArgumentException("readingvalue");
        }

        reading.setSensor(sensor);
        reading.setStatus("PENDING");

        if (reading.getReadingTime() == null) {
            reading.setReadingTime(LocalDateTime.now());
        }

        return readingRepository.save(reading);
    }

    public SensorReading getReading(Long id) {
        return readingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));
    }

    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        return readingRepository.findBySensor_Id(sensorId);
    }
}
