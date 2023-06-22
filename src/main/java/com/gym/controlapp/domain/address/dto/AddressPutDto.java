package com.gym.controlapp.domain.address.dto;

public record AddressPutDto(Long id,
                            String cep,
                            String logradouro,
                            String complemento,
                            String bairro,
                            String localidade,
                            String uf,
                            Long student_id) {
}