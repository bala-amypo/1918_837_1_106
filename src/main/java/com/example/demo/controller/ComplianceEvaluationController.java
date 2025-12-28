package com.example.demo.controller;

import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService complianceEvaluationService;

    public ComplianceEvaluationController(ComplianceEvaluationService complianceEvaluationService) {
        this.complianceEvaluationService = complianceEvaluationService;
    }

    @GetMapping("/compliance/{id}")
    public String checkCompliance(@PathVariable Long id) {
        return complianceEvaluationService.evaluateCompliance(id);
    }
}
