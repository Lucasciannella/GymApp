package com.gym.controlapp.service;

import com.gym.controlapp.dto.StudentPostDto;
import com.gym.controlapp.dto.StudentPutDto;
import com.gym.controlapp.exception.NotFoundException;
import com.gym.controlapp.mapper.StudentMapper;
import com.gym.controlapp.model.Student;
import com.gym.controlapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public Student listByIdOrThrowNotFoundException(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student does not exist"));
    }

    public Student save(StudentPostDto studentPostDto) {
        return studentRepository.save(StudentMapper.INSTANCE.toStudent(studentPostDto));
    }

    public Student update(StudentPutDto studentPutDto){
        Student savedStudent = listByIdOrThrowNotFoundException(studentPutDto.id());
        Student student =  studentMapper.toStudent(studentPutDto);
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        var studentToBeDeleted = this.listByIdOrThrowNotFoundException(id);
        studentRepository.delete(studentToBeDeleted);
    }
}