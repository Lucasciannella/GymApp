package com.gym.controlapp.domain.student.transformer;

import com.gym.controlapp.domain.student.dto.StudentPutDto;
import com.gym.controlapp.domain.student.model.Student;

public class StudentPutTransformer implements IStudentPutTransformer {
    @Override
    public Student transform(Student student, StudentPutDto studentPutDto) {
        return Student.builder()
                .id(student.getId())
                .cpf(studentPutDto.cpf())
                .nome(studentPutDto.nome())
                .nascimento(studentPutDto.nascimento())
                .telefone(studentPutDto.telefone())
                .build();
    }
}