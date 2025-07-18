package com.gymapp.academia.exercicio.mapper;

import com.gymapp.academia.exercicio.domain.Exercicio;
import com.gymapp.academia.exercicio.dto.ExercicioRequest;
import com.gymapp.academia.treino.domain.Treino;
import org.springframework.stereotype.Component;

@Component
public class ExercicioMapper {

    public static Exercicio toEntity(ExercicioRequest dto,Treino treino) {
        Exercicio exercicio = new Exercicio();
        exercicio.setName(dto.name());
        exercicio.setSeries(dto.series());
        exercicio.setRepeticoes(dto.repeticoes());
        exercicio.setTreino(treino);
        return exercicio;
    }
}
