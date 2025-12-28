package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;

    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location createLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public Location getLocation(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Location> getAllLocations() {
        return repository.findAll();
    }
}
