package com.gym.controlapp.dto.address;

import com.gym.controlapp.model.Student;

public record AddressPostDto(String cep,
                             String logradouro,
                             String complemento,
                             String bairro,
                             String localidade,
                             String uf,
                             Long student_id) {
}