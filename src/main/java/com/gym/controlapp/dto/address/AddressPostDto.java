package com.gym.controlapp.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressPostDto(
        @NotBlank
        String cep,

        @NotBlank
        String logradouro,

        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        String localidade,

        @NotBlank
        String uf,

        @NotNull
        Long student_id) {
}