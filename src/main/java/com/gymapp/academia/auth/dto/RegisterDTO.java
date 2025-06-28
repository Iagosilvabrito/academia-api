package com.gymapp.academia.auth.dto;

import com.gymapp.academia.auth.domain.Role;

import java.util.Set;

public record RegisterDTO(String name, String password, Set<Role> roles) {
}
