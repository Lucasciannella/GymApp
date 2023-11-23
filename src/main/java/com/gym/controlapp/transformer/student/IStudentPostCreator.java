package com.gym.controlapp.transformer.student;

import com.gym.controlapp.dto.student.StudentPostDto;
import com.gym.controlapp.model.Student;

public interface IStudentPostCreator {
    Student create(StudentPostDto studentPostDto);
}