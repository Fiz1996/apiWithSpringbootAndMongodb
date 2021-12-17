package com.example.springbootWithMongoDb.repository;

import com.example.springbootWithMongoDb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {
    Optional<Student> findStudentByEmail(String email );
}
