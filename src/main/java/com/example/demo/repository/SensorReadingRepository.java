package com.example.demo.repository;

import com.example.demo.entity.SensorReading;
import com.example.demo.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    List<SensorReading> findBySensor(Sensor sensor);

    List<SensorReading> findByReadingTimeBetween(LocalDateTime start, LocalDateTime end);
}
