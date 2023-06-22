package com.gym.controlapp.domain.student.service;

import com.gym.controlapp.domain.student.dto.StudentPostDto;
import com.gym.controlapp.domain.student.dto.StudentPutDto;
import com.gym.controlapp.config.exception.NotFoundException;
import com.gym.controlapp.domain.student.model.Student;
import com.gym.controlapp.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public Student listByIdOrThrowNotFoundException(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student does not exist"));
    }

    public Student save(StudentPostDto studentPostDto) {
        Student student = Student.builder()
                .nome(studentPostDto.nome())
                .nascimento(studentPostDto.nascimento())
                .cpf(studentPostDto.cpf())
                .build();
        return studentRepository.save(student);
    }

    public Student update(StudentPutDto studentPutDto) {
        var savedStudent = listByIdOrThrowNotFoundException(studentPutDto.id());
        var student = Student.builder()
                .id(savedStudent.getId())
                .nome(studentPutDto.nome() != null ? studentPutDto.nome() : savedStudent.getNome())
                .nascimento(studentPutDto.nascimento() != null ? studentPutDto.nascimento() : savedStudent.getNascimento())
                .cpf(studentPutDto.cpf() != null ? studentPutDto.cpf() : savedStudent.getCpf())
                .build();
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        var studentToBeDeleted = this.listByIdOrThrowNotFoundException(id);
        studentRepository.delete(studentToBeDeleted);
    }
}