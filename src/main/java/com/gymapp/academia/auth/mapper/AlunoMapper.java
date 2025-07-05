package com.gymapp.academia.auth.mapper;

import com.gymapp.academia.auth.domain.Aluno;
import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.auth.dto.RegisterAlunoDTO;

public class AlunoMapper {
    public static Aluno toEntity(RegisterAlunoDTO dto, User user){
        Aluno aluno = new Aluno();
        aluno.setName(dto.name());
        aluno.setTelefone(dto.telefone());
        aluno.setUser(user);
        return aluno;
    }
}
