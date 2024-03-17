package com.aruiz.ExamSystem.service.impl;

import com.aruiz.ExamSystem.controller.dtos.StudentRequest;
import com.aruiz.ExamSystem.domain.Student;
import com.aruiz.ExamSystem.repository.StudentRepository;
import com.aruiz.ExamSystem.service.StudentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentServices {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(StudentRequest estudentRequest) throws Exception {
        return null;
    }

    @Override
    public List<Student> findAll() throws Exception {
        return null;
    }

    @Override
    public Student findById(Long id) throws Exception {
        return null;
    }

    @Override
    public String deleteById(Long id) throws Exception {
        return null;
    }

    @Override
    public Student updateById(Long id) throws Exception {
        return null;
    }
}
