package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final List<Sensor> sensors = new ArrayList<>();

    @Override
    public List<Sensor> getAllSensors() {
        return sensors;
    }

    @Override
    public Sensor addSensor(Long locationId, Sensor sensor) {
        sensors.add(sensor);
        return sensor;
    }
}
