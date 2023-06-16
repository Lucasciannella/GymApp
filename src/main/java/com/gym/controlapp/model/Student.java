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
    private String nome;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate nascimento;
    @Column(unique = true, length = 11)
    private String cpf;
    @OneToMany(mappedBy = "student")
    private List<Address> address;
}