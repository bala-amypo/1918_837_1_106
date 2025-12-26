package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ REQUIRED BY TESTS + CONTROLLER
    public User register(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new IllegalArgumentException("email already exists");
                });

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // ✅ REQUIRED BY CONTROLLER
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("invalid email"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("invalid password");
        }
        return user;
    }
}
