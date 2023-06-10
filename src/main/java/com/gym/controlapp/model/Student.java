package com.gym.controlapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate nascimento;
    @Column(unique = true, length = 11)
    private String cpf;
    @OneToMany(mappedBy = "student")
    private List<Address> address;

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

    public List<Address> getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}