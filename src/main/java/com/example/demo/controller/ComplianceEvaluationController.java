package com.example.demo.controller;

import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService complianceService;

    public ComplianceEvaluationController(
            ComplianceEvaluationService complianceService) {
        this.complianceService = complianceService;
    }

    @GetMapping("/{sensorId}")
    public String evaluate(@PathVariable Long sensorId) {
        return complianceService.evaluateCompliance(sensorId);
    }
}
