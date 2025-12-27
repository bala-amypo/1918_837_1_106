package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    // Stored as STRING (DB + tests)
    private String role;

    public User() {
    }

    // ✅ Constructor used by tests
    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role.name();
    }

    // Optional constructor
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ✅ TESTS EXPECT STRING
    public String getRole() {
        return role;
    }

    // ✅ TESTS PASS Role
    public void setRole(Role role) {
        this.role = role.name();
    }

    // Optional safety
    public void setRole(String role) {
        this.role = role;
    }
}
