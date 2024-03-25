package com.aruiz.ExamSystem.controller.mapper;

import com.aruiz.ExamSystem.controller.dtos.ExamResponse;
import com.aruiz.ExamSystem.domain.Exam;
import com.aruiz.ExamSystem.domain.Teacher;
import com.aruiz.ExamSystem.entity.TeacherEntity;
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
                    .teacherEntity(teacherMapper.toTeacherResponse(teacher))
                    .build();
        }




    }

}
