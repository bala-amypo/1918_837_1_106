package com.example.demo.config;

import com.example.demo.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(Long userId, String email, Role role) {
        return "DUMMY_JWT_" + userId + "_" + role.name();
    }
}
