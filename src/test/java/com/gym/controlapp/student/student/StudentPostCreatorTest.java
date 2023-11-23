package com.gym.controlapp.student.student;

import com.gym.controlapp.dto.student.StudentPostDto;
import com.gym.controlapp.model.Student;
import com.gym.controlapp.transformer.student.StudentPostCreator;
import com.gym.controlapp.student.utils.StudentCreator;
import com.gym.controlapp.student.utils.StudentPostRequestBodyCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentPostCreatorTest {
    StudentPostCreator studentPostCreator;
    private StudentPostDto studentPostDto;
    private Student expectedStudent;

    @BeforeEach
    void setUp() {
        studentPostDto = StudentPostRequestBodyCreator.createStudentPostDto();
        studentPostCreator = new StudentPostCreator();
        expectedStudent = StudentCreator.createValidStudent();
    }

    @Test
    void return_student_from_dto_to_domain_object() {
        var student = studentPostCreator.create(studentPostDto);

        Assertions.assertEquals(expectedStudent.getNome(), student.getNome());
        Assertions.assertEquals(expectedStudent.getCpf(), student.getCpf());
        Assertions.assertEquals(expectedStudent.getNascimento(), student.getNascimento());
    }
}