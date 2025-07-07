package com.gymapp.academia.aluno.domain;

import com.gymapp.academia.auth.domain.User;
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
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String telefone;
    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;
}
