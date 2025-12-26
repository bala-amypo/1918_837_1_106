package com.example.demo.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.impl.SensorServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorServiceImpl service;

    public SensorController(SensorServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/{locationId}")
    public Sensor create(@PathVariable Long locationId,
                         @RequestBody Sensor sensor) {
        return service.createSensor(locationId, sensor);
    }

    @GetMapping
    public List<Sensor> getAll() {
        return service.getAllSensors();
    }

    @GetMapping("/{id}")
    public Sensor get(@PathVariable Long id) {
        return service.getSensor(id);
    }
}
