package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // ✅ ADD THIS FIELD (MATCH REPOSITORY)
    @Column(unique = true, nullable = false)
    private String sensorCode;

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

    public String getSensorCode() {
        return sensorCode;
    }

    public String getSensorType() {
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

    public void setSensorCode(String sensorCode) {
        this.sensorCode = sensorCode;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
