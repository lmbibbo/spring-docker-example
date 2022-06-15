package com.example.springdockerexample.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springdockerexample.model.Student;
import com.example.springdockerexample.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
}
