package com.gym.controlapp.mapper;

import com.gym.controlapp.dto.StudentPostDto;
import com.gym.controlapp.dto.StudentPutDto;
import com.gym.controlapp.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    public static final StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    public abstract Student toStudent(StudentPostDto studentPostDto);

    public abstract Student toStudent(StudentPutDto studentPutDto);
}