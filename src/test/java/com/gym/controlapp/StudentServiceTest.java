package com.gym.controlapp;

import com.gym.controlapp.config.exception.NotFoundException;
import com.gym.controlapp.domain.student.model.Student;
import com.gym.controlapp.domain.student.repository.StudentRepository;
import com.gym.controlapp.domain.student.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        BDDMockito.when(studentRepository.save(ArgumentMatchers.any(Student.class))).thenReturn(StudentCreator.createValidStudent());
        BDDMockito.when(studentRepository.findAll()).thenReturn(List.of(StudentCreator.createValidStudent()));
    }

    @Test
    void save_Student_whenSuccessful() {
        Student student = studentService.save(StudentPostRequestBodyCreator.createStudentPostDto());

        Assertions.assertNotNull(student);
    }

    @Test
    void list_ReturnsListOfStudents_WhenSuccessful() {
        var expectedStudent = StudentCreator.createValidStudent();

        var studentList = studentService.listAll();

        Assertions.assertEquals(expectedStudent.getNome(), studentList.get(0).getNome());
    }

    @Test
    void throwsException_if_updatable_student_not_exists_in_database() {
        var mensagemDeErro = "Student does not exist";

        var exception = Assertions.assertThrows(NotFoundException.class, () -> studentService.update(StudentPutReQuestBodyCreator.createStudentPutDto()));

        Assertions.assertEquals(mensagemDeErro, exception.getMessage());
    }
}