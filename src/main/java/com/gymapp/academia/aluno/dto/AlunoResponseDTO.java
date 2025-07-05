package com.gymapp.academia.aluno.dto;

import com.gymapp.academia.auth.domain.Role;

public record AlunoResponseDTO(String username, String telefone, Role roles) {
}
