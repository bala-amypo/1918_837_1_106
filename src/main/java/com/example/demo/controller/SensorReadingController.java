package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
public class SensorReadingController {

    private final SensorReadingService service;

    public SensorReadingController(SensorReadingService service) {
        this.service = service;
    }

    @PostMapping("/{sensorId}")
    public SensorReading create(@PathVariable Long sensorId, @RequestBody SensorReading r) {
        return service.submitReading(sensorId, r);
    }

    @GetMapping("/sensor/{sensorId}")
    public List<SensorReading> bySensor(@PathVariable Long sensorId) {
        return service.getReadingsBySensor(sensorId);
    }

    @GetMapping("/{id}")
    public SensorReading get(@PathVariable Long id) {
        return service.getReading(id);
    }
}
