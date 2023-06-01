package com.gym.controlapp.dto;

import java.time.LocalDate;
import java.util.List;

public record AlunoDto(String nome, LocalDate nascimento, String cpf, List<EnderecoDto> enderecoDto) {
}