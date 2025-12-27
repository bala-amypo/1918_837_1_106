package com.example.demo.controller;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Compliance Threshold Controller",
     description = "APIs for compliance thresholds")
public class ComplianceThresholdController {

    private final ComplianceThresholdService service;

    public ComplianceThresholdController(ComplianceThresholdService service) {
        this.service = service;
    }

    @Operation(summary = "Create compliance threshold")
    @PostMapping
    public ComplianceThreshold create(@RequestBody ComplianceThreshold threshold) {
        return service.createThreshold(threshold);
    }

    @Operation(summary = "Get threshold by ID")
    @GetMapping("/{id}")
    public ComplianceThreshold get(@PathVariable Long id) {
        return service.getThreshold(id);
    }

    @Operation(summary = "Get threshold by sensor type")
    @GetMapping("/sensor/{type}")
    public ComplianceThreshold getBySensorType(@PathVariable String type) {
        return service.getThresholdBySensorType(type);
    }

    @Operation(summary = "Get all thresholds")
    @GetMapping
    public List<ComplianceThreshold> getAll() {
        return service.getAllThresholds();
    }
}
