package com.example.demo.controller;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService complianceService;

    public ComplianceEvaluationController(ComplianceEvaluationService complianceService) {
        this.complianceService = complianceService;
    }

    @PostMapping("/evaluate/{readingId}")
    public ComplianceLog evaluate(@PathVariable Long readingId) {
        return complianceService.evaluateReading(readingId);
    }

    @GetMapping("/reading/{readingId}")
    public List<ComplianceLog> getLogsByReading(@PathVariable Long readingId) {
        return complianceService.getLogsByReading(readingId);
    }

    @GetMapping("/{id}")
    public ComplianceLog getLog(@PathVariable Long id) {
        return complianceService.getLog(id);
    }
}
