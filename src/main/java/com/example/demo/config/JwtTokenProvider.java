package com.example.demo.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Key key;
    private final long validityInMilliseconds;

    // Matches AuthController usage
    public JwtTokenProvider(String secret, int validitySeconds) {
        if (secret.getBytes().length < 32) {
            secret = secret + "012345678901234567890123456789"; // pad to 32 bytes
        }
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMilliseconds = validitySeconds * 1000L;
    }

    // Default constructor
    public JwtTokenProvider() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        this.validityInMilliseconds = 24 * 60 * 60 * 1000L; // 1 day
    }

    // Validate token — used in JwtAuthenticationFilter
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // Generate token — matches AuthController signature
