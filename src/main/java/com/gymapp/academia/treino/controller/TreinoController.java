package com.gymapp.academia.treino.controller;

import com.gymapp.academia.aluno.service.AlunoService;
import com.gymapp.academia.treino.dto.TreinoRequestDTO;
import com.gymapp.academia.treino.dto.TreinoResponseDTO;
import com.gymapp.academia.treino.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("treino")
public class TreinoController {
    @Autowired
    private TreinoService treinoService;

    @PostMapping("/criar")
    @PreAuthorize("hasRole('PROFESSOR')")
    public ResponseEntity<Void> createTraining(@RequestBody TreinoRequestDTO dto){
        treinoService.criarTreino(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("listar")
    public ResponseEntity<List<TreinoResponseDTO>>listar(){
        return ResponseEntity.ok(treinoService.listar());
    }
}
