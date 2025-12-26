package com.example.demo.service;

import com.example.demo.entity.Sensor;
import java.util.List;
import java.util.Optional;

public interface SensorService {
    Sensor save(Sensor sensor);
    List<Sensor> findAll();
    Optional<Sensor> findById(Long id);
}
