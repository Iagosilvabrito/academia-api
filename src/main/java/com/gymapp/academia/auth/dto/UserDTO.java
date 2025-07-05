package com.gymapp.academia.auth.dto;

import com.gymapp.academia.auth.domain.Role;

public record UserDTO (Long id, String username, Role role){
}
