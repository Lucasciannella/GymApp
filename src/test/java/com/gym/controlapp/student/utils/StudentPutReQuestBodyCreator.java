package com.gym.controlapp.student.utils;

import com.gym.controlapp.dto.student.StudentPutDto;

public class StudentPutReQuestBodyCreator {

    public static StudentPutDto createStudentPutDto(){
        var student =  StudentCreator.createValidStudent();
        return new StudentPutDto(student.getId(), student.getNome(), student.getNascimento(), student.getCpf(), student.getTelefone());
    }
}
