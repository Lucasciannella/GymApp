package com.gym.controlapp.model;

import com.gym.controlapp.dto.AlunoDto;
import com.gym.controlapp.dto.EnderecoDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AlunoDtoMapper implements Function<Aluno, AlunoDto> {
    @Override
    public AlunoDto apply(Aluno aluno) {
        return new AlunoDto(
                aluno.getNome(),
                aluno.getNascimento(),
                aluno.getCpf(),
                aluno.getEndereco()
                        .stream()
                        .map(endereco -> new EnderecoDto(
                                endereco.getCep(),
                                endereco.getLogradouro(),
                                endereco.getComplemento(),
                                endereco.getBairro(),
                                endereco.getLocalidade(),
                                endereco.getUf()
                        )).collect(Collectors.toList())
        );
    }
}