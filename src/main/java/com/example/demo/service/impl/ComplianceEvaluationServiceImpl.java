package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.repository.ComplianceLogRepository;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

    private final ComplianceLogRepository logRepository;
    private final ComplianceThresholdRepository thresholdRepository;

    public ComplianceEvaluationServiceImpl(ComplianceLogRepository logRepository,
                                           ComplianceThresholdRepository thresholdRepository) {
        this.logRepository = logRepository;
        this.thresholdRepository = thresholdRepository;
    }

    @Override
    public List<ComplianceLog> evaluateCompliance() {
        return logRepository.findAll();
    }

    @Override
    public List<ComplianceThreshold> getThresholds() {
        return thresholdRepository.findAll();
    }
}