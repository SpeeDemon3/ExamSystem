package com.aruiz.ExamSystem.service.impl;

import com.aruiz.ExamSystem.controller.dtos.ExamRequest;
import com.aruiz.ExamSystem.domain.Exam;
import com.aruiz.ExamSystem.entity.ExamEntity;
import com.aruiz.ExamSystem.repository.ExamRepository;
import com.aruiz.ExamSystem.service.ExamService;
import com.aruiz.ExamSystem.service.converter.ExamConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamConverter examConverter;


    @Override
    public Exam save(ExamRequest examRequest) throws Exception {

        log.info("Saving exam, teacherID {}, SubjectName {}", examRequest.getIdTeacherEntity(), examRequest.getSubjectName());

        ExamEntity examEntity = examConverter.toExamEntity(examRequest);

        log.info("EntitySave ID {}", examEntity.getId());

        ExamEntity examEntitySave = examRepository.save(examEntity);


        return examConverter.toExam(examEntitySave);
    }

    @Override
    public List<Exam> findAll() throws Exception {
        return null;
    }

    @Override
    public Exam findById(Long id) throws Exception {
        return null;
    }

    @Override
    public String deleteById(Long id) throws Exception {
        return null;
    }

    @Override
    public Exam uploadById(Long id, ExamRequest examRequest) throws Exception {
        return null;
    }
}
