package com.example.demo.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    // ✅ GET ALL SENSORS (NO PARAMS – CORRECT)
    @Operation(summary = "Get all sensors")
    @GetMapping
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

    // ✅ POST SENSOR WITH PATH PARAM (THIS WAS NOT SHOWING)
    @Operation(summary = "Add sensor to a location")
    @PostMapping("/{locationId}")
    public Sensor addSensor(
            @Parameter(description = "Location ID", example = "1")
            @PathVariable Long locationId,

            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Sensor details",
                    required = true
            )
            @RequestBody Sensor sensor
    ) {
        return sensorService.addSensor(locationId, sensor);
    }
}
