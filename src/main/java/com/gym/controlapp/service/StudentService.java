package com.gym.controlapp.service;

import com.gym.controlapp.config.exception.NotFoundException;
import com.gym.controlapp.dto.student.StudentPostDto;
import com.gym.controlapp.dto.student.StudentPutDto;
import com.gym.controlapp.model.Student;
import com.gym.controlapp.repository.StudentRepository;
import com.gym.controlapp.transformer.student.IStudentPostCreator;
import com.gym.controlapp.transformer.student.IStudentPutCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final IStudentPostCreator studentTransformer;
    private final IStudentPutCreator studentPutTransformer;

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public Student listByIdOrThrowNotFoundException(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student does not exist"));
    }

    public Student save(StudentPostDto studentPostDto) {
        return studentRepository.save(studentTransformer.create(studentPostDto));
    }

    public Student update(StudentPutDto studentPutDto) {
        var savedStudent = listByIdOrThrowNotFoundException(studentPutDto.id());
        return studentRepository.save(studentPutTransformer.create(savedStudent, studentPutDto));
    }

    public void delete(Long id) {
        var studentToBeDeleted = this.listByIdOrThrowNotFoundException(id);
        studentRepository.delete(studentToBeDeleted);
    }
}