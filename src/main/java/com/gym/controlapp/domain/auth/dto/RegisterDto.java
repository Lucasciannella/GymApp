package com.gym.controlapp.domain.auth.dto;

import com.gym.controlapp.domain.auth.model.UserRole;

public record RegisterDto(String login, String password, UserRole role) {
}