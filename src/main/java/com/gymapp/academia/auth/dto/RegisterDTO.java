package com.gymapp.academia.auth.dto;

import com.gymapp.academia.auth.domain.Role;


public record RegisterDTO(String username, String password, Role roles) {
}
