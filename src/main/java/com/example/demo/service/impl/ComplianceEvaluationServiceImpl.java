package com.example.demo.service;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.entity.ComplianceThreshold;
import java.util.List;

public interface ComplianceEvaluationService {
    List<ComplianceLog> evaluateCompliance();
    List<ComplianceThreshold> getThresholds();
}
