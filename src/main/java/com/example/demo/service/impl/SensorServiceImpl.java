package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository repository;

    public SensorServiceImpl(SensorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sensor save(Sensor sensor) {
        return repository.save(sensor);
    }

    @Override
    public List<Sensor> findAll() {
        return repository.findAll();
    }
}
