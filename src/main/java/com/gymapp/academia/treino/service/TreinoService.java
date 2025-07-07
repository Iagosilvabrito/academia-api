package com.gymapp.academia.treino.service;

import com.gymapp.academia.aluno.domain.Aluno;
import com.gymapp.academia.aluno.repository.AlunoRepository;
import com.gymapp.academia.treino.domain.Treino;
import com.gymapp.academia.treino.dto.TreinoRequestDTO;
import com.gymapp.academia.treino.mapper.TreinoMapper;
import com.gymapp.academia.treino.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TreinoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private TreinoRepository treinoRepository;

    public void criarTreino(TreinoRequestDTO dto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Aluno aluno = alunoRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Treino treino = TreinoMapper.toEntity(dto,aluno);
        treinoRepository.save(treino);

    }
}
