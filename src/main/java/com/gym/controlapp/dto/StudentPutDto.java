package com.gym.controlapp.dto;

import java.time.LocalDate;

public record StudentPutDto(Long id, String nome,
                            LocalDate nascimento,
                            String cpf) {
}
