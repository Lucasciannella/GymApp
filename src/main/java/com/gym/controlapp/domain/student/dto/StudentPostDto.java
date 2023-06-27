package com.gym.controlapp.domain.student.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record StudentPostDto(@NotBlank(message = "Nome inválido ou vazio, tente novamente.")
                             String nome,

                             @NotBlank(message = "Idade invalida ou vazia, tente novamente.")
                             @JsonFormat(pattern = "dd-MM-yyyy") LocalDate nascimento,

                             @CPF(message = "Cpf inválido ou vazio, tente novamente.")
                             String cpf,

                             @NotBlank(message = "Telefone inválido ou vazio, tente novamente.")
                             String telefone) {
}