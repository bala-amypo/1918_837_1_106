package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.entity.SensorReading;
import com.example.demo.repository.ComplianceLogRepository;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.repository.SensorReadingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceEvaluationServiceImpl {

    private final SensorReadingRepository readingRepo;
    private final ComplianceThresholdRepository thresholdRepo;
    private final ComplianceLogRepository logRepo;

    public ComplianceEvaluationServiceImpl(
            SensorReadingRepository r,
            ComplianceThresholdRepository t,
            ComplianceLogRepository l) {
        this.readingRepo = r;
        this.thresholdRepo = t;
        this.logRepo = l;
    }

    public ComplianceLog evaluateReading(Long readingId) {
        List<ComplianceLog> existing = logRepo.findBySensorReading_Id(readingId);
        if (!existing.isEmpty()) return existing.get(0);

        SensorReading r = readingRepo.findById(readingId)
                .orElseThrow(() -> new RuntimeException("not found"));

        ComplianceThreshold t = thresholdRepo.findBySensorType(
                r.getSensor().getSensorType()).orElseThrow();

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(r);
        log.setStatusAssigned(
                r.getReadingValue() < t.getMinValue() ||
                r.getReadingValue() > t.getMaxValue()
                        ? "UNSAFE" : "SAFE"
        );
        return logRepo.save(log);
    }
}
