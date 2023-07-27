package com.gym.controlapp.domain.student.transformer;

import com.gym.controlapp.domain.student.dto.StudentPutDto;
import com.gym.controlapp.domain.student.model.Student;

public interface IStudentPutTransformer {
    Student transform(Student student, StudentPutDto studentPutDto);
}