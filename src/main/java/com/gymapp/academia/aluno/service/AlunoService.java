package com.gymapp.academia.aluno.service;
import com.gymapp.academia.aluno.dto.AlunoUpdateDTO;
import com.gymapp.academia.aluno.mapper.AlunoMapper;
import com.gymapp.academia.aluno.domain.Aluno;
import com.gymapp.academia.aluno.repository.AlunoRepository;
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
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        Aluno aluno = alunoRepository.findByUserUsername(auth)
                .orElseThrow(() -> new RuntimeException("User not found"));

        AlunoMapper.updateAluno(aluno, dto);

        alunoRepository.save(aluno);

    }


}

