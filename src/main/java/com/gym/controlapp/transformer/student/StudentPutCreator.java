package com.gym.controlapp.transformer.student;

import com.gym.controlapp.dto.student.StudentPutDto;
import com.gym.controlapp.model.Student;
import com.gym.controlapp.transformer.student.IStudentPutCreator;
import org.springframework.stereotype.Component;

@Component
public class StudentPutCreator implements IStudentPutCreator {
    @Override
    public Student create(Student student, StudentPutDto studentPutDto) {
        return Student.builder()
                .id(student.getId())
                .cpf(studentPutDto.cpf())
                .nome(studentPutDto.nome())
                .nascimento(studentPutDto.nascimento())
                .telefone(studentPutDto.telefone())
                .build();
    }
}