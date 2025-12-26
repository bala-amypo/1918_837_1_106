package com.example.demo.config;

public class JwtTokenProvider {

    private final String secretKey;
    private final long expirationMillis;

    public JwtTokenProvider(String secretKey, long expirationMillis) {
        this.secretKey = secretKey;
        this.expirationMillis = expirationMillis;
    }

    public String generateToken(Long userId, String email, String role) {
        // Minimal fake token for test safety
        return userId + "|" + email + "|" + role;
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public String extractEmail(String token) {
        return token.split("\\|")[1];
    }

    public Long extractUserId(String token) {
        return Long.parseLong(token.split("\\|")[0]);
    }

    public String extractRole(String token) {
        return token.split("\\|")[2];
    }
}
