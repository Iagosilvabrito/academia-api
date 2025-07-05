package com.gymapp.academia.auth.dto;

import com.gymapp.academia.auth.domain.User;

public record RegisterAlunoDTO(String username, String password,String name, String telefone, User user) {
}
