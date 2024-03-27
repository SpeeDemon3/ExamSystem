package com.aruiz.ExamSystem.service.converter;

import com.aruiz.ExamSystem.controller.dtos.ExamRequest;
import com.aruiz.ExamSystem.domain.Exam;
import com.aruiz.ExamSystem.domain.Student;
import com.aruiz.ExamSystem.domain.Teacher;
import com.aruiz.ExamSystem.entity.ExamEntity;
import com.aruiz.ExamSystem.entity.StudentEntity;
import com.aruiz.ExamSystem.entity.TeacherEntity;
import com.aruiz.ExamSystem.service.StudentService;
import com.aruiz.ExamSystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ExamConverter {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherConverter teacherConverter;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentConverter studentConverter;

    public Exam toExam(ExamEntity entity) {

        if (entity.getTeacher() != null) {
            return Exam.builder()
                    .id(entity.getId())
                    .subjectName(entity.getSubjectName())
                    .dateExam(entity.getDateExam())
                    .examDurationMinutes(entity.getExamDurationMinutes())
                    .noteStudent(entity.getNoteStudent())
                    .teacher(teacherConverter.toTeacher(entity.getTeacher()))
                    .student(studentConverter.toStudent(entity.getStudent()))
                    .build();
        } else {
            log.error("Teacher not exist");
            throw new RuntimeException("Teacher not exist");
        }

    }

    public ExamEntity toExamEntity(Exam exam) {


        if (exam.getTeacher() != null) {
            return ExamEntity.builder()
                    .id(exam.getId())
                    .subjectName(exam.getSubjectName())
                    .dateExam(exam.getDateExam())
                    .examDurationMinutes(exam.getExamDurationMinutes())
                    .noteStudent(exam.getNoteStudent())
                    .teacher(teacherConverter.toTeacherEntity(exam.getTeacher()))
                    .student(studentConverter.toStudentEntity(exam.getStudent()))
                    .build();
        } else {
            log.error("Teacher not exist");
            throw new RuntimeException("Teacher not exist");
        }

    }

    public ExamEntity toExamEntity(ExamRequest examRequest) throws Exception {

        Optional<Teacher> optionalTeacher = Optional.ofNullable(teacherService.findById(examRequest.getTeacherId()));

        Optional<Student> optionalStudent = Optional.ofNullable(studentService.findById(examRequest.getStudentId()));

        if (optionalTeacher.isPresent() && optionalStudent.isPresent()) {

            TeacherEntity teacherEntity = teacherConverter.toTeacherEntity(optionalTeacher.get());

            log.info("teacherEntity ID in converter toExamEntity => {}", teacherEntity.getId());

            StudentEntity studentEntity = studentConverter.toStudentEntity(optionalStudent.get());

            log.info("studentEntity ID in converter toExamEntity => {}", studentEntity.getId());


            return ExamEntity.builder()
                    .id(null)
                    .subjectName(examRequest.getSubjectName())
                    .dateExam(examRequest.getDateExam())
                    .examDurationMinutes(examRequest.getExamDurationMinutes())
                    .noteStudent(examRequest.getNoteStudent())
                    .teacher(teacherEntity)
                    .student(studentEntity)
                    .build();
        } else {
            return null;
        }


    }



}
