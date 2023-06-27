package com.gym.controlapp.domain.student.controller;


import com.gym.controlapp.domain.student.dto.StudentPostDto;
import com.gym.controlapp.domain.student.dto.StudentPutDto;
import com.gym.controlapp.domain.student.model.Student;
import com.gym.controlapp.domain.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> listAllStudents() {
        return studentService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getById(@PathVariable Long id) {
        return studentService.listByIdOrThrowNotFoundException(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student save(@Valid @RequestBody StudentPostDto studentPostDto) {
        return studentService.save(studentPostDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Student update(@Valid @RequestBody StudentPutDto studentPutDto) {
        return studentService.update(studentPutDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}