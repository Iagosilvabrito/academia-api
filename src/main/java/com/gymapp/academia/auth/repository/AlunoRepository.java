package com.gymapp.academia.auth.repository;

import com.gymapp.academia.auth.domain.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    Optional<Aluno> findByUserUsername(String username);
}
