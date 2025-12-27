package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // ✅ REQUIRED FIELD
    private String sensorType;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    // getters & setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSensorType() {   // ✅ THIS FIXES ERROR #2
        return sensorType;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
