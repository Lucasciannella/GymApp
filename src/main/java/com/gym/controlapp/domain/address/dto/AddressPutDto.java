package com.gym.controlapp.domain.address.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressPutDto(

        @NotBlank
        Long id,

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

        @NotBlank
        Long student_id) {
}