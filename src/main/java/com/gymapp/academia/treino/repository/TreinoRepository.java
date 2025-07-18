package com.gymapp.academia.treino.repository;

import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.treino.domain.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TreinoRepository extends JpaRepository<Treino, Long> {
    List<Treino> findByAlunoUserUsername(String username);
}
