package com.gym.controlapp;

import com.gym.controlapp.domain.student.dto.StudentPutDto;

public class StudentPutReQuestBodyCreator {

    public static StudentPutDto createStudentPutDto(){
        var student =  StudentCreator.createValidStudent();
        return new StudentPutDto(student.getId(), student.getNome(), student.getNascimento(), student.getCpf(), student.getTelefone());
    }
}
