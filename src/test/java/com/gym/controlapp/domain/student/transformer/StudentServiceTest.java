package com.gym.controlapp.domain.student.transformer;

import com.gym.controlapp.config.exception.NotFoundException;
import com.gym.controlapp.domain.student.dto.StudentPostDto;
import com.gym.controlapp.domain.student.model.Student;
import com.gym.controlapp.domain.student.repository.StudentRepository;
import com.gym.controlapp.domain.student.service.StudentService;
import com.gym.controlapp.domain.student.utils.StudentCreator;
import com.gym.controlapp.domain.student.utils.StudentPostRequestBodyCreator;
import com.gym.controlapp.domain.student.utils.StudentPutReQuestBodyCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {
    StudentPostDto studentPostDto;
    Student student;

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @Mock
    IStudentPostTransformer studentPostTrasnformer;

    @BeforeEach
    void setUp() {
        studentPostDto = StudentPostRequestBodyCreator.createStudentPostDto();
        student = StudentCreator.createValidStudent();
        BDDMockito.when(studentRepository.save(ArgumentMatchers.any(Student.class))).thenReturn(student);
        BDDMockito.when(studentRepository.findAll()).thenReturn(List.of(student));
        Mockito.when(studentPostTrasnformer.transform(studentPostDto)).thenReturn(student);
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

    @Test
    void ivoke_method_transform_from_student_transformer_to_tranform_student_dto_object_in_student() {
        studentService.save(studentPostDto);

        Mockito.verify(studentPostTrasnformer, Mockito.times(1)).transform(studentPostDto);
    }
}