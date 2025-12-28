package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor-readings")
public class SensorReadingController {

    private final SensorReadingService sensorReadingService;

    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    @PostMapping
    public SensorReading create(@RequestBody SensorReading reading) {
        return sensorReadingService.save(reading);
    }

    @GetMapping
    public List<SensorReading> getAll() {
        return sensorReadingService.findAll();
    }
}
