package com.example.demo.controller;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.service.ComplianceEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation Controller",
     description = "APIs for compliance evaluation")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService service;

    public ComplianceEvaluationController(ComplianceEvaluationService service) {
        this.service = service;
    }

    @Operation(summary = "Evaluate compliance for a sensor reading")
    @PostMapping("/evaluate/{readingId}")
    public ComplianceLog evaluate(@PathVariable Long readingId) {
        return service.evaluateReading(readingId);
    }

    @Operation(summary = "Get compliance logs by reading ID")
    @GetMapping("/reading/{readingId}")
    public List<ComplianceLog> getByReading(@PathVariable Long readingId) {
        return service.getLogsByReading(readingId);
    }

    @Operation(summary = "Get compliance log by ID")
    @GetMapping("/{id}")
    public ComplianceLog get(@PathVariable Long id) {
        return service.getLog(id);
    }
}
