package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication Controller",
     description = "APIs for user authentication")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider =
            new JwtTokenProvider("secret", 3600000);

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Register new user")
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @Operation(summary = "Login user")
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());

        String token = tokenProvider.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
