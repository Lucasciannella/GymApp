package com.gym.controlapp.student.utils;

import com.gym.controlapp.model.Student;

import java.time.LocalDate;

public class StudentCreator {

    public static Student createValidStudent(){
        return Student.builder()
                .id(1L)
                .nome("Lucas ciannella")
                .cpf("13127633700")
                .nascimento(LocalDate.of(1999,11,4))
                .address(null)
                .telefone("90001112234")
                .build();
    }
}
