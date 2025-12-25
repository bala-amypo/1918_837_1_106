package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceThresholdService;

import java.util.List;

public class ComplianceThresholdServiceImpl implements ComplianceThresholdService {

    private final ComplianceThresholdRepository repository;

    public ComplianceThresholdServiceImpl(ComplianceThresholdRepository repository) {
        this.repository = repository;
    }

    public ComplianceThreshold createThreshold(ComplianceThreshold t) {
        if (t.getMinValue() >= t.getMaxValue()) {
            throw new IllegalArgumentException("minvalue");
        }
        return repository.save(t);
    }

    public ComplianceThreshold getThreshold(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
    }

    public ComplianceThreshold getThresholdBySensorType(String type) {
        return repository.findBySensorType(type)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
    }

    public List<ComplianceThreshold> getAllThresholds() {
        return repository.findAll();
    }
}
