package com.gym.controlapp.domain.student.service;

import com.gym.controlapp.config.exception.NotFoundException;
import com.gym.controlapp.domain.student.dto.StudentPostDto;
import com.gym.controlapp.domain.student.dto.StudentPutDto;
import com.gym.controlapp.domain.student.model.Student;
import com.gym.controlapp.domain.student.repository.StudentRepository;
import com.gym.controlapp.domain.student.transformer.IStudentPostTransformer;
import com.gym.controlapp.domain.student.transformer.IStudentPutTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final IStudentPostTransformer studentTransformer;
    private final IStudentPutTransformer studentPutTransformer;

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public Student listByIdOrThrowNotFoundException(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student does not exist"));
    }

    public Student save(StudentPostDto studentPostDto) {
        return studentRepository.save(studentTransformer.transform(studentPostDto));
    }

    public Student update(StudentPutDto studentPutDto) {
        var savedStudent = listByIdOrThrowNotFoundException(studentPutDto.id());
        return studentRepository.save(studentPutTransformer.transform(savedStudent, studentPutDto));
    }

    public void delete(Long id) {
        var studentToBeDeleted = this.listByIdOrThrowNotFoundException(id);
        studentRepository.delete(studentToBeDeleted);
    }
}