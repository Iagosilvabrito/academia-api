package com.gymapp.academia.treino.domain;

import com.gymapp.academia.aluno.domain.Aluno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Treino {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate dataCriacao;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;



}
