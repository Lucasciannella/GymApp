package com.gym.controlapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate nascimento;

    @Column(unique = true, length = 11, nullable = false)
    private String cpf;

    @Column(length = 11, nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "student")
    private List<Address> address;
}