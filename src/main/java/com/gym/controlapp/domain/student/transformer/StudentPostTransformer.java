package com.gym.controlapp.domain.student.transformer;

import com.gym.controlapp.domain.student.dto.StudentPostDto;
import com.gym.controlapp.domain.student.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentPostTransformer implements IStudentPostTransformer {
    @Override
    public Student transform(StudentPostDto studentPostDto) {
        return Student.builder()
                .nome(studentPostDto.nome())
                .nascimento(studentPostDto.nascimento())
                .cpf(studentPostDto.cpf())
                .telefone(studentPostDto.telefone())
                .build();
    }
}