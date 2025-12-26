package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.service.impl.LocationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationServiceImpl service;

    public LocationController(LocationServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Location create(@RequestBody Location location) {
        return service.createLocation(location);
    }

    @GetMapping("/{id}")
    public Location get(@PathVariable Long id) {
        return service.getLocation(id);
    }
}
