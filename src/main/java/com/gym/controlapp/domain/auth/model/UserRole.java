package com.gym.controlapp.domain.auth.model;

public enum UserRole {
    ADMIN("Admin"),
    USER("User");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
