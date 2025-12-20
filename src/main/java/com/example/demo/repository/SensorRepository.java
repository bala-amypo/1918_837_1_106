package com.example.demo.repository;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Optional<Sensor> findBySensorCode(String sensorCode);

    List<Sensor> findByLocation(Location location);

    List<Sensor> findByIsActive(Boolean isActive);
}
