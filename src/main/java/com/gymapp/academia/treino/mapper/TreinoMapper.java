package com.gymapp.academia.treino.mapper;

import com.gymapp.academia.aluno.domain.Aluno;
import com.gymapp.academia.treino.domain.Treino;
import com.gymapp.academia.treino.dto.TreinoRequestDTO;
import com.gymapp.academia.treino.dto.TreinoResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class TreinoMapper {

    public static Treino toEntity(TreinoRequestDTO dto, Aluno aluno){
        Treino treino = new Treino();
        treino.setName(dto.name());
        treino.setDescription(dto.descriaco());
        treino.setDataCriacao(LocalDate.now());
        treino.setAluno(aluno);
        return treino;
    }

    public static TreinoResponseDTO toDTO(Treino treino){
        return new TreinoResponseDTO(
                treino.getId(),
                treino.getName(),
                treino.getDescription(),
                treino.getDataCriacao()
        );
    }


}
