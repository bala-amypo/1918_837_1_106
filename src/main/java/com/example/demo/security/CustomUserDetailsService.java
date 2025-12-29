package com.example.demo.security;

import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomUserDetailsService implements UserDetailsService {

    public CustomUserDetailsService(UserRepository repo) {}

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) {
        return null;
    }
}
