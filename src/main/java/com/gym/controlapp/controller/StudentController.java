package com.gym.controlapp.controller;


import com.gym.controlapp.dto.student.StudentPostDto;
import com.gym.controlapp.dto.student.StudentPutDto;
import com.gym.controlapp.model.Student;
import com.gym.controlapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}