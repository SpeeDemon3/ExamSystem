package com.aruiz.ExamSystem.service.impl;

import com.aruiz.ExamSystem.repository.ExamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExamServiceImpl {

    @Autowired
    private ExamRepository examRepository;



}
