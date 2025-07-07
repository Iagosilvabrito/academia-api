package com.gymapp.academia.aluno.controller;

import com.gymapp.academia.aluno.dto.AlunoUpdateDTO;
import com.gymapp.academia.aluno.domain.Aluno;
import com.gymapp.academia.aluno.dto.AlunoResponseDTO;
import com.gymapp.academia.aluno.mapper.AlunoMapper;
import com.gymapp.academia.aluno.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    @GetMapping("perfil")
    public ResponseEntity<AlunoResponseDTO> getAlunoLogado(){
    Aluno aluno = alunoService.getPerfil();
    return ResponseEntity.ok(AlunoMapper.toDTO(aluno));

    }
    @PutMapping("atualizar")
    public ResponseEntity<String> atualizarPerfil(@RequestBody AlunoUpdateDTO dto) {
       alunoService.atualizarPerfil(dto);
       return ResponseEntity.ok("Perfil atualizado com sucesso!");
    }


}
