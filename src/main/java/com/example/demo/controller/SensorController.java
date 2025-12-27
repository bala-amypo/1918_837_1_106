package com.example.demo.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensor Controller", description = "APIs for managing sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Operation(summary = "Create a sensor for a location")
    @PostMapping("/{locationId}")
    public Sensor createSensor(@PathVariable Long locationId,
                               @RequestBody Sensor sensor) {
        return sensorService.createSensor(locationId, sensor);
    }

    @Operation(summary = "Get sensor by ID")
    @GetMapping("/{id}")
    public Sensor getSensor(@PathVariable Long id) {
        return sensorService.getSensor(id);
    }

    @Operation(summary = "Get all sensors")
    @GetMapping
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }
}
