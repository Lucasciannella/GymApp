package com.gym.controlapp.student.utils;

import com.gym.controlapp.dto.student.StudentPostDto;

public class StudentPostRequestBodyCreator {

    public static StudentPostDto createStudentPostDto(){
        return  new StudentPostDto(StudentCreator.createValidStudent().getNome(),StudentCreator.createValidStudent().getNascimento(),StudentCreator.createValidStudent().getCpf(), StudentCreator.createValidStudent().getTelefone());
    }
}
