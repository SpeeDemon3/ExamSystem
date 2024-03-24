package com.aruiz.ExamSystem.service;

import com.aruiz.ExamSystem.controller.dtos.TeacherRequest;
import com.aruiz.ExamSystem.domain.Teacher;

import java.util.List;

public interface TeacherServices {

    Teacher save(TeacherRequest teacherRequest) throws Exception;

    List<Teacher> findAll() throws Exception;

    Teacher findById(Long id) throws Exception;

    String deleteById(Long id) throws Exception;

    Teacher updateById(Long id, TeacherRequest teacherRequest) throws Exception;

}
