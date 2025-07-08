package com.gymapp.academia.treino.service;

import com.gymapp.academia.aluno.domain.Aluno;
import com.gymapp.academia.aluno.repository.AlunoRepository;
import com.gymapp.academia.treino.domain.Treino;
import com.gymapp.academia.treino.dto.TreinoRequestDTO;
import com.gymapp.academia.treino.dto.TreinoResponseDTO;
import com.gymapp.academia.treino.mapper.TreinoMapper;
import com.gymapp.academia.treino.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private TreinoRepository treinoRepository;

    public void criarTreino(TreinoRequestDTO dto){
        Aluno aluno = alunoRepository.findById(dto.alunoId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Treino treino = TreinoMapper.toEntity(dto,aluno);
        treinoRepository.save(treino);

    }
    public List<TreinoResponseDTO> listar(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return treinoRepository.findByAlunoUserUsername(username).stream()
                .map(TreinoMapper::toDTO)
                .toList();

    }
}
