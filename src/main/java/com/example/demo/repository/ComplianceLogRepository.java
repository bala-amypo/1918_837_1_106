package com.example.demo.repository;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComplianceLogRepository extends JpaRepository<ComplianceLog, Long> {

    List<ComplianceLog> findBySensorReading(SensorReading sensorReading);
}
