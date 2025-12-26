package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;

public class LocationServiceImpl {

    private final LocationRepository repo;

    public LocationServiceImpl(LocationRepository repo) {
        this.repo = repo;
    }

    public Location createLocation(Location l) {
        if (l.getRegion() == null)
            throw new IllegalArgumentException("region required");
        return repo.save(l);
    }

    public Location getLocation(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}
