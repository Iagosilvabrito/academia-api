package com.gymapp.academia.exercicio.repository;

import com.gymapp.academia.exercicio.domain.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio,Long> {
}
