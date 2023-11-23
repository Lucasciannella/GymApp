package com.gym.controlapp.transformer.student;

import com.gym.controlapp.dto.student.StudentPutDto;
import com.gym.controlapp.model.Student;

public interface IStudentPutCreator {
    Student create(Student student, StudentPutDto studentPutDto);
}