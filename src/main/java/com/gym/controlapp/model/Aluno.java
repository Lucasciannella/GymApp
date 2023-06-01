package com.gym.controlapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate nascimento;
    @Column(unique = true, length = 11)
    private String cpf;
    @OneToMany(mappedBy = "aluno")
    private List<Endereco> endereco;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }
}