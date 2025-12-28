package com.example.demo.controller;

import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService complianceEvaluationService;

    public ComplianceEvaluationController(ComplianceEvaluationService complianceEvaluationService) {
        this.complianceEvaluationService = complianceEvaluationService;
    }

    @GetMapping("/compliance")
    public String checkCompliance() {
        return complianceEvaluationService.evaluateCompliance();
    }
}
