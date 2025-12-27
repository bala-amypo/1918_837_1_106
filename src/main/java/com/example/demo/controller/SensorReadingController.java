package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Reading Controller",
     description = "APIs for sensor readings")
public class SensorReadingController {

    private final SensorReadingService service;

    public SensorReadingController(SensorReadingService service) {
        this.service = service;
    }

    @Operation(summary = "Submit sensor reading")
    @PostMapping("/{sensorId}")
    public SensorReading submit(@PathVariable Long sensorId,
                                @RequestBody SensorReading reading) {
        return service.submitReading(sensorId, reading);
    }

    @Operation(summary = "Get reading by ID")
    @GetMapping("/{id}")
    public SensorReading get(@PathVariable Long id) {
        return service.getReading(id);
    }

    @Operation(summary = "Get readings by sensor ID")
    @GetMapping("/sensor/{sensorId}")
    public List<SensorReading> getBySensor(@PathVariable Long sensorId) {
        return service.getReadingsBySensor(sensorId);
    }
}
