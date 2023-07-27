package com.gym.controlapp.domain.student.transformer;

import com.gym.controlapp.domain.student.utils.StudentCreator;
import com.gym.controlapp.domain.student.utils.StudentPutReQuestBodyCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//TODO:refatorar esse teste.
public class StudentPutTranformerTest {

    @Test
    void return_student_from_dto_to_domain_object() {
        var expectedStudent = StudentCreator.createValidStudent();
        var studentPutDto = StudentPutReQuestBodyCreator.createStudentPutDto();

        StudentPutTransformer studentPutTransformer = new StudentPutTransformer();
        var student = studentPutTransformer.transform(expectedStudent, studentPutDto);

        Assertions.assertEquals(expectedStudent.getNome(), student.getNome());
    }
}