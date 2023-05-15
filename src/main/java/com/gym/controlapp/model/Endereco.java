package com.gym.controlapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
}