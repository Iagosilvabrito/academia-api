package com.gymapp.academia.exercicio.controller;

import com.gymapp.academia.exercicio.dto.ExercicioRequest;
import com.gymapp.academia.exercicio.service.ExercicioService;
import com.gymapp.academia.treino.domain.Treino;
import com.gymapp.academia.treino.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ExercicioController {
    @Autowired
    private ExercicioService exercicioService;


    @PostMapping("/{treinoId}/exercicios")
    ResponseEntity<Void> toAddTraining(@PathVariable Long treinoId, @RequestBody ExercicioRequest body){
        exercicioService.criarExercicio(body,treinoId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
