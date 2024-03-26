package com.aruiz.ExamSystem.controller.mapper;

import com.aruiz.ExamSystem.controller.dtos.ExamRequest;
import com.aruiz.ExamSystem.controller.dtos.ExamResponse;
import com.aruiz.ExamSystem.domain.Exam;
import com.aruiz.ExamSystem.domain.Teacher;
import com.aruiz.ExamSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExamMapper {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    public ExamResponse toExamResponse(Exam exam) throws Exception {

        Optional<Teacher> optionalTeacher = Optional.ofNullable(teacherService.findById(exam.getId()));

        if (optionalTeacher.isPresent()) {

            Teacher teacher = optionalTeacher.get();

            ExamResponse.builder()
                    .id(exam.getId())
                    .subjectName(exam.getSubjectName())
                    .dateExam(exam.getDateExam())
                    .examDurationMinutes(exam.getExamDurationMinutes())
                    .teacher(teacher)
                    .build();
        } else {
            throw new RuntimeException("Teacher not found");
        }

        return null;
    }

    public ExamResponse toExamResponse(ExamRequest examRequest) throws Exception {

        Optional<Teacher> teacherOptional = Optional.ofNullable(teacherService.findById(examRequest.getIdTeacherEntity()));

        if (teacherOptional.isPresent()) {

            Teacher teacher = teacherOptional.get();

            return ExamResponse.builder()
                    .id(null)
                    .subjectName(examRequest.getSubjectName())
                    .dateExam(examRequest.getDateExam())
                    .examDurationMinutes(examRequest.getExamDurationMinutes())
                    .teacher(teacher)
                    .build();


        } else {
            throw new RuntimeException("Teacher not found");
        }

    }


    public Exam toExamModel(ExamRequest examRequest) throws Exception {

        Optional<Teacher> teacherOptional = Optional.ofNullable(teacherService.findById(examRequest.getIdTeacherEntity()));

        if (teacherOptional.isPresent()) {

            Teacher teacher = teacherOptional.get();


            return Exam.builder()
                    .subjectName(examRequest.getSubjectName())
                    .dateExam(examRequest.getDateExam())
                    .examDurationMinutes(examRequest.getExamDurationMinutes())
                    .teacherId(null)
                    .build();

        }

        throw new RuntimeException("Teacher not found");

    }


}
