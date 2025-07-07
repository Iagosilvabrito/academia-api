package com.gymapp.academia.auth.domain;

import com.gymapp.academia.treino.domain.Treino;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int serie;
    private int repeticoes;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    private Treino treino;
}
