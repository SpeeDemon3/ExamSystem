package com.aruiz.ExamSystem.service.converter;

import com.aruiz.ExamSystem.controller.dtos.ExamRequest;
import com.aruiz.ExamSystem.domain.Exam;
import com.aruiz.ExamSystem.entity.ExamEntity;
import com.aruiz.ExamSystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExamConverter {

    public Exam toExam(ExamEntity entity) {

        if (entity.getTeacherId() > 0) {
            return Exam.builder()
                    .id(entity.getId())
                    .subjectName(entity.getSubjectName())
                    .dateExam(entity.getDateExam())
                    .examDurationMinutes(entity.getExamDurationMinutes())
                    .teacherId(entity.getTeacherId())
                    .build();
        } else {
            log.error("Teacher not exist");
            throw new RuntimeException("Teacher not exist");
        }

    }

    public ExamEntity toExamEntity(Exam exam) {

        if (exam.getTeacherId() > 0) {
            return ExamEntity.builder()
                    .id(exam.getId())
                    .subjectName(exam.getSubjectName())
                    .dateExam(exam.getDateExam())
                    .examDurationMinutes(exam.getExamDurationMinutes())
                    .teacherId(exam.getTeacherId())
                    .build();
        } else {
            log.error("Teacher not exist");
            throw new RuntimeException("Teacher not exist");
        }

    }

    public ExamEntity toExamEntity(ExamRequest examRequest) {
        return ExamEntity.builder()
                .id(null)
                .subjectName(examRequest.getSubjectName())
                .dateExam(examRequest.getDateExam())
                .examDurationMinutes(examRequest.getExamDurationMinutes())
                .teacherId(examRequest.getIdTeacherEntity())
                .build();
    }



}
