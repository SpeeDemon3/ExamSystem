package com.aruiz.ExamSystem.controller.mapper;

import com.aruiz.ExamSystem.controller.dtos.ExamRequest;
import com.aruiz.ExamSystem.controller.dtos.ExamResponse;
import com.aruiz.ExamSystem.domain.Exam;
import com.aruiz.ExamSystem.domain.Student;
import com.aruiz.ExamSystem.domain.Teacher;
import com.aruiz.ExamSystem.service.StudentService;
import com.aruiz.ExamSystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ExamMapper {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    public ExamResponse toExamResponse(Exam exam) throws Exception {

        return ExamResponse.builder()
                .id(exam.getId())
                .subjectName(exam.getSubjectName())
                .dateExam(exam.getDateExam())
                .examDurationMinutes(exam.getExamDurationMinutes())
                .noteStudent(exam.getNoteStudent())
                .teacher(exam.getTeacher())
                .student(exam.getStudent())
                .build();
    }

    public ExamResponse toExamResponse(ExamRequest examRequest) throws Exception {

        Optional<Teacher> teacherOptional = Optional.ofNullable(teacherService.findById(examRequest.getTeacherId()));

        Optional<Student> studentOptional = Optional.ofNullable(studentService.findById(examRequest.getStudentId()));

        if (teacherOptional.isPresent() && studentOptional.isPresent()) {

            Teacher teacher = teacherOptional.get();

            Student student = studentOptional.get();

            return ExamResponse.builder()
                    .id(null)
                    .subjectName(examRequest.getSubjectName())
                    .dateExam(examRequest.getDateExam())
                    .examDurationMinutes(examRequest.getExamDurationMinutes())
                    .noteStudent(examRequest.getNoteStudent())
                    .teacher(teacher)
                    .student(student)
                    .build();


        } else {
            throw new RuntimeException("Teacher or Student not found");
        }

    }


    public Exam toExamModel(ExamRequest examRequest) throws Exception {

        Optional<Teacher> teacherOptional = Optional.ofNullable(teacherService.findById(examRequest.getTeacherId()));

        Optional<Student> studentOptional = Optional.ofNullable(studentService.findById(examRequest.getStudentId()));

        if (teacherOptional.isPresent() && studentOptional.isPresent()) {

            Teacher teacher = teacherOptional.get();

            Student student = studentOptional.get();

            return Exam.builder()
                    .subjectName(examRequest.getSubjectName())
                    .dateExam(examRequest.getDateExam())
                    .examDurationMinutes(examRequest.getExamDurationMinutes())
                    .noteStudent(examRequest.getNoteStudent())
                    .teacher(teacher)
                    .student(student)
                    .build();

        }

        throw new RuntimeException("Teacher or Student not found");

    }


}
