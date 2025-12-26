package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.impl.SensorReadingServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/readings")
public class SensorReadingController {

    private final SensorReadingServiceImpl service;

    public SensorReadingController(SensorReadingServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/{sensorId}")
    public SensorReading submit(@PathVariable Long sensorId,
                                @RequestBody SensorReading reading) {
        return service.submitReading(sensorId, reading);
    }

    @GetMapping("/{id}")
    public SensorReading get(@PathVariable Long id) {
        return service.getReading(id);
    }
}
