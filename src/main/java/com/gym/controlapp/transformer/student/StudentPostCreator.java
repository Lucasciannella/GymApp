package com.gym.controlapp.transformer.student;

import com.gym.controlapp.dto.student.StudentPostDto;
import com.gym.controlapp.model.Student;
import com.gym.controlapp.transformer.student.IStudentPostCreator;
import org.springframework.stereotype.Component;

@Component
public class StudentPostCreator implements IStudentPostCreator {
    @Override
    public Student create(StudentPostDto studentPostDto) {
        return Student.builder()
                .nome(studentPostDto.nome())
                .nascimento(studentPostDto.nascimento())
                .cpf(studentPostDto.cpf())
                .telefone(studentPostDto.telefone())
                .build();
    }
}