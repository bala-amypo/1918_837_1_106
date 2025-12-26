package com.example.demo.service.impl;

import com.example.demo.entity.SensorReading;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.service.SensorReadingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository sensorReadingRepository;

    public SensorReadingServiceImpl(SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    @Override
    public SensorReading save(SensorReading reading) {
        return sensorReadingRepository.save(reading);
    }

    @Override
    public List<SensorReading> findAll() {
        return sensorReadingRepository.findAll();
    }

    @Override
    public Optional<SensorReading> findById(Long id) {
        return sensorReadingRepository.findById(id);
    }
}
