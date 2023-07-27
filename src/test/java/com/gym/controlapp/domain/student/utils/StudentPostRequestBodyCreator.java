package com.gym.controlapp.domain.student.utils;

import com.gym.controlapp.domain.student.dto.StudentPostDto;

public class StudentPostRequestBodyCreator {

    public static StudentPostDto createStudentPostDto(){
        return  new StudentPostDto(StudentCreator.createValidStudent().getNome(),StudentCreator.createValidStudent().getNascimento(),StudentCreator.createValidStudent().getCpf(), StudentCreator.createValidStudent().getTelefone());
    }
}
