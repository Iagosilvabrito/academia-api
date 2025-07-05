package com.gymapp.academia.aluno.mapper;

import com.gymapp.academia.aluno.dto.AlunoUpdateDTO;
import com.gymapp.academia.auth.domain.Aluno;
import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.aluno.dto.AlunoResponseDTO;
import com.gymapp.academia.auth.dto.RegisterAlunoDTO;

public class AlunoMapper {
    public static Aluno toEntity(RegisterAlunoDTO dto, User user){
        Aluno aluno = new Aluno();
        aluno.setName(dto.name());
        aluno.setTelefone(dto.telefone());
        aluno.setUser(user);
        return aluno;
    }

    public static AlunoResponseDTO toDTO(Aluno response ){
        return new AlunoResponseDTO(
                response.getName(),
                response.getTelefone(),
                response.getUser().getRoles()
                );
    }
    public static void updateAluno(Aluno aluno, AlunoUpdateDTO dto){
                if (dto.name() != null){
                    aluno.setName(dto.name());
        }
                if (dto.telefone() != null){
                    aluno.setTelefone(dto.telefone());
                }
    }
}
