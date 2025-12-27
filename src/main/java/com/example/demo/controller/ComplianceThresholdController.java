package com.example.demo.controller;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thresholds")
public class ComplianceThresholdController {

    private final ComplianceThresholdService service;

    public ComplianceThresholdController(ComplianceThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public ComplianceThreshold create(@RequestBody ComplianceThreshold threshold) {
        return service.createThreshold(threshold);
    }

    @GetMapping("/{id}")
    public ComplianceThreshold get(@PathVariable Long id) {
        return service.getThreshold(id);
    }

    @GetMapping("/sensor/{type}")
    public ComplianceThreshold getBySensorType(@PathVariable String type) {
        return service.getThresholdBySensorType(type);
    }

    @GetMapping
    public List<ComplianceThreshold> getAll() {
        return service.getAllThresholds();
    }
}
