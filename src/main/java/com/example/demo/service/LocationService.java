package com.example.demo.service;

import com.example.demo.entity.Location;
import java.util.List;
import java.util.Optional;

public interface LocationService {
    Location save(Location location);
    List<Location> findAll();
    Optional<Location> findById(Long id);
}
