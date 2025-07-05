package com.gymapp.academia.aluno.service;
import com.gymapp.academia.aluno.dto.AlunoUpdateDTO;
import com.gymapp.academia.aluno.mapper.AlunoMapper;
import com.gymapp.academia.auth.domain.Aluno;
import com.gymapp.academia.auth.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno getPerfil(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        return alunoRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public void atualizarPerfil(AlunoUpdateDTO dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Aluno aluno = alunoRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        AlunoMapper.updateAluno(aluno, dto);

        alunoRepository.save(aluno);

    }


}

