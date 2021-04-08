package com.org.data.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.data.entity.Subject;
import com.org.data.repository.SubjectRepository;

import java.util.List;

/**
 * Rest Controller to provide the Subject data based on Role
 * @author Kishore Hebbar
 *
 */

@RestController
@RequestMapping("/Subject")
public class SubjectResource {

    private final SubjectRepository subjectRepository;

    public SubjectResource(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
}
