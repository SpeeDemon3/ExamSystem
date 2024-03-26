package com.aruiz.ExamSystem.service.converter;

import com.aruiz.ExamSystem.controller.dtos.ExamRequest;
import com.aruiz.ExamSystem.domain.Exam;
import com.aruiz.ExamSystem.domain.Teacher;
import com.aruiz.ExamSystem.entity.ExamEntity;
import com.aruiz.ExamSystem.entity.TeacherEntity;
import com.aruiz.ExamSystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@Slf4j
public class ExamConverter {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherConverter teacherConverter;

    public Exam toExam(ExamEntity entity) {

        if (entity.getTeacher() != null) {
            return Exam.builder()
                    .id(entity.getId())
                    .subjectName(entity.getSubjectName())
                    .dateExam(entity.getDateExam())
                    .examDurationMinutes(entity.getExamDurationMinutes())
                    .teacherId(entity.getTeacher())
                    .build();
        } else {
            log.error("Teacher not exist");
            throw new RuntimeException("Teacher not exist");
        }

    }

    public ExamEntity toExamEntity(Exam exam) {

        if (exam.getTeacherId() != null) {
            return ExamEntity.builder()
                    .id(exam.getId())
                    .subjectName(exam.getSubjectName())
                    .dateExam(exam.getDateExam())
                    .examDurationMinutes(exam.getExamDurationMinutes())
                    .teacher(exam.getTeacherId())
                    .build();
        } else {
            log.error("Teacher not exist");
            throw new RuntimeException("Teacher not exist");
        }

    }

    public ExamEntity toExamEntity(ExamRequest examRequest) throws Exception {

        Optional<Teacher> optionalTeacher = Optional.ofNullable(teacherService.findById(examRequest.getIdTeacherEntity()));

        if (optionalTeacher.isPresent()) {

            TeacherEntity teacherEntity = teacherConverter.toTeacherEntity(optionalTeacher.get());

            return ExamEntity.builder()
                    .id(null)
                    .subjectName(examRequest.getSubjectName())
                    .dateExam(examRequest.getDateExam())
                    .examDurationMinutes(examRequest.getExamDurationMinutes())
                    .teacher(teacherEntity)
                    .build();
        } else {
            return null;
        }


    }



}
