package com.org.data.controller;


import lombok.extern.slf4j.Slf4j;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.data.entity.Student;
import com.org.data.repository.StudentRepository;

import java.util.List;

/**
 * Rest Controller to provide the Student data based on Role
 * @author Kishore Hebbar
 *
 */

@RestController
@RequestMapping("/Student")
@Slf4j
public class StudentResource {

private final StudentRepository studentRepository;

    public StudentResource(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    public List<Student> getAllStudents(){
    	log.info("Inside the getAllStudents");
        return studentRepository.findAll();
    }
}
