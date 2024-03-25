package com.aruiz.ExamSystem.service;

import com.aruiz.ExamSystem.controller.dtos.ExamRequest;
import com.aruiz.ExamSystem.domain.Exam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ExamService {

    Exam save(@RequestBody ExamRequest examRequest) throws Exception;

    List<Exam> findAll() throws Exception;

    Exam findById(@RequestParam Long id) throws Exception;

    String deleteById(@RequestParam Long id) throws Exception;

    Exam uploadById(@RequestParam Long id, @RequestBody ExamRequest examRequest) throws Exception;


}
