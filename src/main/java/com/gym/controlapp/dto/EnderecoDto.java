package com.gym.controlapp.dto;

public record EnderecoDto(String cep,
                          String logradouro,
                          String complemento,
                          String bairro,
                          String localidade,
                          String uf) {
}
