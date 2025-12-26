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
public ComplianceLog evaluateReading(Long readingId) {
    ComplianceLog log = new ComplianceLog();
    log.setReadingId(readingId);
    log.setStatus("COMPLIANT");
    return logRepository.save(log);
}

@Override
public List<ComplianceLog> getLogsByReading(Long readingId) {
    return logRepository.findByReadingId(readingId);
}

    @Override
    public List<ComplianceThreshold> getThresholds() {
        return thresholdRepository.findAll();
    }
}