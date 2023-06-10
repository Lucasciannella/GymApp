package com.gym.controlapp.dto;

import java.time.LocalDate;
import java.util.List;

public record StudentDto(String nome,
                         LocalDate nascimento,
                         String cpf, List<AddressDto> addressDtos) {
}