package com.gym.controlapp.domain.student.repository;

import com.gym.controlapp.domain.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}