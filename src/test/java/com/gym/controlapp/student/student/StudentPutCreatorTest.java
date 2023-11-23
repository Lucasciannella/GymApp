package com.gym.controlapp.student.student;

import com.gym.controlapp.dto.student.StudentPutDto;
import com.gym.controlapp.model.Student;
import com.gym.controlapp.transformer.student.StudentPutCreator;
import com.gym.controlapp.student.utils.StudentCreator;
import com.gym.controlapp.student.utils.StudentPutReQuestBodyCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StudentPutCreatorTest {

    private Student expectedStudent;
    private StudentPutDto studentPutDto;
    private StudentPutCreator studentPutCreator;

    @BeforeEach
    void setUp() {
        expectedStudent = StudentCreator.createValidStudent();
        studentPutDto = StudentPutReQuestBodyCreator.createStudentPutDto();
        studentPutCreator = new StudentPutCreator();

    }

    @Test
    void return_student_from_dto_to_domain_object() {
        var student = studentPutCreator.create(expectedStudent, studentPutDto);

        Assertions.assertEquals(expectedStudent.getNome(), student.getNome());
        Assertions.assertEquals(expectedStudent.getNascimento(), student.getNascimento());
    }
}