package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceLogRepository;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.service.ComplianceEvaluationService;

import java.time.LocalDateTime;
import java.util.List;

public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

    private final SensorReadingRepository readingRepo;
    private final ComplianceThresholdRepository thresholdRepo;
    private final ComplianceLogRepository logRepo;

    public ComplianceEvaluationServiceImpl(SensorReadingRepository readingRepo,
                                           ComplianceThresholdRepository thresholdRepo,
                                           ComplianceLogRepository logRepo) {
        this.readingRepo = readingRepo;
        this.thresholdRepo = thresholdRepo;
        this.logRepo = logRepo;
    }

    public ComplianceLog evaluateReading(Long readingId) {
        SensorReading r = readingRepo.findById(readingId)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));

        ComplianceThreshold t = thresholdRepo.findBySensorType(
                r.getSensor().getSensorType())
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));

        List<ComplianceLog> existing = logRepo.findBySensorReading_Id(readingId);
        if (!existing.isEmpty()) {
            return existing.get(0);
        }

        String status = (r.getReadingValue() >= t.getMinValue() &&
                         r.getReadingValue() <= t.getMaxValue())
                         ? "SAFE" : "UNSAFE";

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(r);
        log.setStatusAssigned(status);
        log.setLoggedAt(LocalDateTime.now());

        return logRepo.save(log);
    }

    public List<ComplianceLog> getLogsByReading(Long readingId) {
        return logRepo.findBySensorReading_Id(readingId);
    }

    public ComplianceLog getLog(Long id) {
        return logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}
