package com.example.demo.service;

import com.example.demo.entity.Sensor;
import java.util.List;

public interface SensorService {
    Sensor save(Sensor sensor);
    List<Sensor> findAll();
}
