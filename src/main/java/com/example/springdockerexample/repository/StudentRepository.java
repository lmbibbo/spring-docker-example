package com.example.springdockerexample.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.springdockerexample.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
    
    Optional<Student> findStudentByEmail(String email);
    
    
}
