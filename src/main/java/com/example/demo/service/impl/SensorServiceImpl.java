package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class SensorServiceImpl {

    private final SensorRepository repo;
    private final LocationRepository locationRepo;

    public SensorServiceImpl(SensorRepository repo, LocationRepository locationRepo) {
        this.repo = repo;
        this.locationRepo = locationRepo;
    }

    public Sensor createSensor(Long locationId, Sensor s) {
        if (s.getSensorType() == null)
            throw new IllegalArgumentException("sensorType required");

        Location loc = locationRepo.findById(locationId)
                .orElseThrow(() -> new RuntimeException("not found"));
        s.setLocation(loc);
        return repo.save(s);
    }

    public Sensor getSensor(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public java.util.List<Sensor> getAllSensors() {
        return repo.findAll();
    }
}
