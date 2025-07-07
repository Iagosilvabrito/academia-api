package com.gymapp.academia.treino.dto;

import java.time.LocalDate;

public record TreinoResponseDTO(Long id, String name, String description, LocalDate dataCriacao) {
}
