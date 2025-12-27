package com.example.demo.config;

import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public LocationService locationService(LocationRepository repo) {
        return new LocationServiceImpl(repo);
    }

    @Bean
    public SensorService sensorService(SensorRepository sensorRepo,
                                       LocationRepository locationRepo) {
        return new SensorServiceImpl(sensorRepo, locationRepo);
    }

    @Bean
    public SensorReadingService sensorReadingService(
            SensorReadingRepository readingRepo,
            SensorRepository sensorRepo) {
        return new SensorReadingServiceImpl(readingRepo, sensorRepo);
    }

    @Bean
    public ComplianceThresholdService complianceThresholdService(
            ComplianceThresholdRepository repo) {
        return new ComplianceThresholdServiceImpl(repo);
    }

    @Bean
    public ComplianceEvaluationService complianceEvaluationService(
            SensorReadingRepository readingRepo,
            ComplianceThresholdRepository thresholdRepo,
            ComplianceLogRepository logRepo) {
        return new ComplianceEvaluationServiceImpl(
                readingRepo, thresholdRepo, logRepo);
    }
}
