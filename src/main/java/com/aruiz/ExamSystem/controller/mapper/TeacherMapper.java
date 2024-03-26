package com.aruiz.ExamSystem.controller.mapper;

import com.aruiz.ExamSystem.controller.dtos.TeacherRequest;
import com.aruiz.ExamSystem.controller.dtos.TeacherResponse;
import com.aruiz.ExamSystem.domain.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TeacherMapper {

    // Method to convert a Teacher object to a TeacherResponse object
    // Método para convertir un objeto Teacher a un objeto TeacherResponse
    public TeacherResponse toTeacherResponse(Teacher teacher) {

        if (teacher.getId() != null) {

            return TeacherResponse.builder()
                    .id(teacher.getId())
                    .email(teacher.getEmail())
                    .name(teacher.getName())
                    .age(teacher.getAge())
                    .phoneNumber(teacher.getPhoneNumber())
                    .role(teacher.getRole())
                    .img(teacher.getImg())
                    .build();


        } else {
            log.error("Teacher is empty");
            return null;
        }

    }

    // Method to convert a TeacherRequest object to a TeacherResponse object
    // Método para convertir un objeto TeacherRequest a un objeto TeacherResponse
    public TeacherResponse toTacherResponse(TeacherRequest request) {

        if (request.getEmail() != null) {
            return TeacherResponse.builder()
                    .id(null)
                    .email(request.getEmail())
                    .name(request.getName())
                    .age(request.getAge())
                    .phoneNumber(request.getPhoneNumber())
                    .role(request.getRole())
                    .img(request.getImg())
                    .build();
        } else {
            log.error("Teacher is empty");
            return null;
        }

    }

    // Method to convert a TeacherRequest object to a Teacher object
    // Método para convertir un objeto TeacherRequest a un objeto Teacher
    public Teacher toTeacherModel(TeacherRequest teacherRequest) {

        if (teacherRequest.getEmail() != null) {
            return Teacher.builder()
                    .id(null)
                    .email(teacherRequest.getEmail())
                    .name(teacherRequest.getName())
                    .age(teacherRequest.getAge())
                    .phoneNumber(teacherRequest.getPhoneNumber())
                    .role(teacherRequest.getRole())
                    .img(teacherRequest.getImg())
                    .build();
        } else {
            log.error("Teacher is empty");
            return null;
        }

    }

    public Teacher toTeacherModel(Teacher teacher) {

        if (teacher.getEmail() != null) {
            return Teacher.builder()
                    .id(null)
                    .email(teacher.getEmail())
                    .name(teacher.getName())
                    .age(teacher.getAge())
                    .phoneNumber(teacher.getPhoneNumber())
                    .role(teacher.getRole())
                    .img(teacher.getImg())
                    .build();
        } else {
            log.error("Teacher is empty");
            return null;
        }

    }

}
