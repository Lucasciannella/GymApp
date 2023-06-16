package com.gym.controlapp.dto.student;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record StudentPutDto(Long id, String nome,
                            @JsonFormat(pattern = "dd-MM-yyyy")LocalDate nascimento,
                            String cpf) {
}
