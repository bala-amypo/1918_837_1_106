package com.example.demo.config;

import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorService;
import com.example.demo.service.impl.SensorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public SensorService sensorService(
            SensorRepository sensorRepository,
            LocationRepository locationRepository) {

        return new SensorServiceImpl(sensorRepository, locationRepository);
    }
}
