package com.gym.controlapp.dto.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record StudentPutDto(
        @NotNull(message = "Id inválido ou vazio, tente novamente.")
        Long id,

        @NotBlank(message = "Nome inválido ou vazio, tente novamente.")
        String nome,

        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate nascimento,

        @CPF(message = "Cpf inválido ou vazio, tente novamente.")
        String cpf,

        @NotBlank(message = "Telefone inválido ou vazio, tente novamente.")
        String telefone) {
}