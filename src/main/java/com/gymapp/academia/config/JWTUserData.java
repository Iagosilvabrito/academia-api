package com.gymapp.academia.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String username) {
}
