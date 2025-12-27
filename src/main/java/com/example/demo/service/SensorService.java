package com.example.demo.service;

import com.example.demo.entity.Sensor;
import java.util.List;

public interface SensorService {

    List<Sensor> getAllSensors();

    Sensor addSensor(Long locationId, Sensor sensor);
}
