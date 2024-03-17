package com.aruiz.ExamSystem.controller.mapper;

import com.aruiz.ExamSystem.controller.dtos.StudentRequest;
import com.aruiz.ExamSystem.controller.dtos.StudentResponse;
import com.aruiz.ExamSystem.domain.Student;
import com.aruiz.ExamSystem.service.StudentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StudentMapper {

    @Autowired
    private StudentServices studentServices;

    // Method to convert a Student object to a StudentResponse object
    // Método para convertir un objeto Student a un objeto StudentResponse
    public StudentResponse toStudentResponse(Student student) {

        if (student.getId() != null) {

            return StudentResponse.builder()
                    .id(student.getId())
                    .email(student.getEmail())
                    .name(student.getEmail())
                    .age(student.getAge())
                    .phoneNumber(student.getPhoneNumber())
                    .role(student.getRole())
                    .img(student.getImg())
                    .build();

        } else {
            log.error("Student is empty");
            return null;
        }

    }

    // Method to convert a StudentRequest object to a StudentResponse object
    // Método para convertir un objeto StudentRequest a un objeto StudentResponse
    public StudentResponse toStudentResponse(StudentRequest student) {

        if (student.getEmail() != null) {

            return StudentResponse.builder()
                    .id(null)
                    .email(student.getEmail())
                    .name(student.getEmail())
                    .age(student.getAge())
                    .phoneNumber(student.getPhoneNumber())
                    .role(student.getRole())
                    .img(student.getImg())
                    .build();

        } else {
            log.error("Student is empty");
            return null;
        }

    }

    // Method to convert a StudentRequest object to a Student object
    // Método para convertir un objeto StudentRequest a un objeto Student
    public Student toStudentModel(StudentRequest studentRequest) {

        if (!studentRequest.getName().isEmpty()) {
            return Student.builder()
                    .id(null)
                    .email(studentRequest.getEmail())
                    .name(studentRequest.getName())
                    .age(studentRequest.getAge())
                    .phoneNumber(studentRequest.getPhoneNumber())
                    .role(studentRequest.getRole())
                    .img(studentRequest.getImg())
                    .build();
        } else {
            log.error("Student is not exists.");
            return null;
        }


    }



}
