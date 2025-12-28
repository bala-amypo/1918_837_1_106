package com.example.demo.service.impl;

import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;

@Service   // 🔥 THIS IS VERY IMPORTANT
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

    @Override
    public String evaluateCompliance() {
        return "Compliance evaluated successfully";
    }
}
