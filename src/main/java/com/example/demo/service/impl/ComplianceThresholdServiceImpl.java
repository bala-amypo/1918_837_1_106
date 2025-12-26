package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplianceThresholdServiceImpl implements ComplianceThresholdService {

    private final ComplianceThresholdRepository repository;

    public ComplianceThresholdServiceImpl(ComplianceThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public ComplianceThreshold save(ComplianceThreshold threshold) {
        return repository.save(threshold);
    }

    @Override
    public List<ComplianceThreshold> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ComplianceThreshold> findById(Long id) {
        return repository.findById(id);
    }
}
