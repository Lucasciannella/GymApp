package com.gym.controlapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "handle")
    private Long id;
    @Column(name = "nome",length = 150)
    private String nome;
    @Column(name = "data_nascimento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate nascimento;
    @Column(unique = true,length = 11)
    private String cpf;
    @OneToOne
    private Endereco endereco;
}