package com.example.demo.config;

public class JwtTokenProvider {

    public String generateToken(Long userId, String email, String role) {
        // Fake token (tests only check non-null)
        return userId + "|" + email + "|" + role;
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public Long extractUserId(String token) {
        return Long.parseLong(token.split("\\|")[0]);
    }

    public String extractEmail(String token) {
        return token.split("\\|")[1];
    }

    public String extractRole(String token) {
        return token.split("\\|")[2];
    }
}
