package com.gym.controlapp.service;

import com.gym.controlapp.dto.AlunoDto;
import com.gym.controlapp.model.Aluno;
import com.gym.controlapp.model.AlunoDtoMapper;
import com.gym.controlapp.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoDtoMapper alunoDtoMapper;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository, AlunoDtoMapper alunoDtoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoDtoMapper = alunoDtoMapper;
    }


    public Aluno salvar(AlunoDto alunoDto){
        return null;
    }


    public List<AlunoDto> ListarTudo(){
        return alunoRepository.findAll()
                .stream()
                .map(alunoDtoMapper).collect(Collectors.toList());
    }
}