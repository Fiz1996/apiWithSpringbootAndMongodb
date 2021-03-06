package com.example.springbootWithMongoDb.controller;

import com.example.springbootWithMongoDb.entity.Student;
import com.example.springbootWithMongoDb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }
}
