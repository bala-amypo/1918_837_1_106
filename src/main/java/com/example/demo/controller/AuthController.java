package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserServiceImpl userService;
    private final JwtTokenProvider jwtProvider =
            new JwtTokenProvider("VerySecretKeyForJWTsChangeMe", 3600000);

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User u = userService.login(user.getEmail(), user.getPassword());
        return jwtProvider.generateToken(u.getId(), u.getEmail(), u.getRole().name());
    }
}
