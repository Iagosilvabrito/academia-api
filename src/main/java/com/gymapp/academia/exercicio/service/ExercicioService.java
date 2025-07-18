package com.gymapp.academia.exercicio.service;

import com.gymapp.academia.exercicio.domain.Exercicio;
import com.gymapp.academia.exercicio.dto.ExercicioRequest;
import com.gymapp.academia.exercicio.mapper.ExercicioMapper;
import com.gymapp.academia.exercicio.repository.ExercicioRepository;
import com.gymapp.academia.treino.domain.Treino;
import com.gymapp.academia.treino.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExercicioService {
    @Autowired
    private ExercicioRepository exercicioRepository;
    @Autowired
    private TreinoRepository treinoRepository;

    public void criarExercicio(ExercicioRequest dto, Long treinoId){
        Treino treino = treinoRepository.findById(treinoId)
                .orElseThrow(()-> new RuntimeException("training mot found"));

        Exercicio exercicio = ExercicioMapper.toEntity(dto,treino);
        exercicioRepository.save(exercicio);
    }
}
