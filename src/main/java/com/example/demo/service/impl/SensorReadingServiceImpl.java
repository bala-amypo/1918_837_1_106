package com.example.demo.service.impl;

import com.example.demo.entity.SensorReading;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.service.SensorReadingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository repository;

    public SensorReadingServiceImpl(SensorReadingRepository repository) {
        this.repository = repository;
    }

    @Override
    public SensorReading save(SensorReading reading) {
        return repository.save(reading);
    }

    @Override
    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        return repository.findBySensorId(sensorId);
    }

    @Override
    public Optional<SensorReading> getReading(Long readingId) {
        return repository.findById(readingId);
    }

    @Override
    public void submitReading(Long sensorId, SensorReading reading) {
        reading.setSensorId(sensorId);
        repository.save(reading);
    }
}
