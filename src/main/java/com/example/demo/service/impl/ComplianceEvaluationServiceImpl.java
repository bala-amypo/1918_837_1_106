package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

    private final SensorReadingRepository readingRepository;
    private final ComplianceThresholdRepository thresholdRepository;
    private final ComplianceLogRepository logRepository;

    public ComplianceEvaluationServiceImpl(SensorReadingRepository readingRepository,
                                           ComplianceThresholdRepository thresholdRepository,
                                           ComplianceLogRepository logRepository) {
        this.readingRepository = readingRepository;
        this.thresholdRepository = thresholdRepository;
        this.logRepository = logRepository;
    }

    @Override
    public ComplianceLog evaluateReading(Long readingId) {
        SensorReading reading = readingRepository.findById(readingId)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));

        String sensorType = reading.getSensor().getSensorType();

        ComplianceThreshold threshold = thresholdRepository.findBySensorType(sensorType)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));

        String status;
        if (reading.getReadingValue() >= threshold.getMinValue()
                && reading.getReadingValue() <= threshold.getMaxValue()) {
            status = "SAFE";
        } else {
            status = "UNSAFE";
        }

        List<ComplianceLog> existingLogs =
                logRepository.findBySensorReading(reading);

        ComplianceLog log;
        if (existingLogs.isEmpty()) {
            log = new ComplianceLog(reading, threshold, status,
                    "Auto evaluated", LocalDateTime.now());
        } else {
            log = existingLogs.get(0);
            log.setStatusAssigned(status);
            log.setThresholdUsed(threshold);
            log.setLoggedAt(LocalDateTime.now());
        }

        return logRepository.save(log);
    }

    @Override
    public List<ComplianceLog> getLogsByReading(Long readingId) {
        SensorReading reading = readingRepository.findById(readingId)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));
        return logRepository.findBySensorReading(reading);
    }

    @Override
    public ComplianceLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}
