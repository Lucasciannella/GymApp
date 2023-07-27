package com.gym.controlapp.domain.student.service;

import com.gym.controlapp.domain.student.dto.StudentPostDto;
import com.gym.controlapp.domain.student.model.Student;

public interface IStudentPostTransformer {
    Student transform(StudentPostDto studentPostDto);
}