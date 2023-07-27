package com.gym.controlapp.domain.student.transformer;

import com.gym.controlapp.domain.student.dto.StudentPostDto;
import com.gym.controlapp.domain.student.model.Student;
import com.gym.controlapp.domain.student.utils.StudentCreator;
import com.gym.controlapp.domain.student.utils.StudentPostRequestBodyCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentPostTransformerTest {
    StudentPostTransformer studentTransformer;
    private StudentPostDto studentPostDto;
    private Student expectedStudent;

    @BeforeEach
    void setUp() {
        studentPostDto = StudentPostRequestBodyCreator.createStudentPostDto();
        studentTransformer = new StudentPostTransformer();
        expectedStudent = StudentCreator.createValidStudent();
    }

    @Test
    void return_student_from_dto_to_domain_object() {
        var student = studentTransformer.transform(studentPostDto);

        Assertions.assertEquals(expectedStudent.getNome(), student.getNome());
        Assertions.assertEquals(expectedStudent.getCpf(), student.getCpf());
        Assertions.assertEquals(expectedStudent.getNascimento(), student.getNascimento());
    }
}