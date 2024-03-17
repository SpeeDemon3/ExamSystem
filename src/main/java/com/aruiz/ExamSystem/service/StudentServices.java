package com.aruiz.ExamSystem.service;

import com.aruiz.ExamSystem.controller.dtos.StudentRequest;
import com.aruiz.ExamSystem.domain.Student;

import java.util.List;

public interface StudentServices {

    Student save(StudentRequest estudentRequest) throws Exception;

    List<Student> findAll() throws Exception;

    Student findById(Long id) throws Exception;

    String deleteById(Long id) throws Exception;

    Student updateById(Long id) throws Exception;

}
