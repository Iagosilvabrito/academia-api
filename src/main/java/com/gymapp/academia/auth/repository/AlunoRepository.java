package com.gymapp.academia.auth.repository;

import com.gymapp.academia.auth.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
