package com.gymapp.academia.aluno.repository;

import com.gymapp.academia.aluno.domain.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    Optional<Aluno> findByUserUsername(String username);
}
