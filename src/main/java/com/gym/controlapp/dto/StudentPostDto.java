package com.gym.controlapp.dto;

import java.time.LocalDate;

public record StudentPostDto(String nome,
                             LocalDate nascimento,
                             String cpf) {
}