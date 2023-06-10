package com.gym.controlapp.controller;


import com.gym.controlapp.dto.StudentPostDto;
import com.gym.controlapp.dto.StudentPutDto;
import com.gym.controlapp.model.Student;
import com.gym.controlapp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> listAllStudents() {
        return studentService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getById(Long id) {
        return studentService.listByIdOrThrowNotFoundException(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student save(@RequestBody StudentPostDto studentPostDto) {
        return studentService.save(studentPostDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Student update(@RequestBody StudentPutDto studentPutDto) {
        return studentService.update(studentPutDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        studentService.delete(id);
    }
}