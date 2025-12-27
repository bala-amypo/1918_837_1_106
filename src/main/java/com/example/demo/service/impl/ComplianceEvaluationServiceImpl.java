package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;

@Service   // 🔴 VERY IMPORTANT
public class ComplianceEvaluationServiceImpl
        implements ComplianceEvaluationService {

    private final SensorRepository sensorRepository;

    public ComplianceEvaluationServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public String evaluateCompliance(Long sensorId) {

        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new RuntimeException("Sensor not found"));

        // simple example logic
        if ("TEMPERATURE".equalsIgnoreCase(sensor.getSensorType())) {
            return "COMPLIANT";
        }
        return "NON-COMPLIANT";
    }
}
