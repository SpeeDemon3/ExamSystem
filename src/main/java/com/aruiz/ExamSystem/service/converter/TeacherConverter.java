package com.aruiz.ExamSystem.service.converter;

import com.aruiz.ExamSystem.controller.dtos.TeacherRequest;
import com.aruiz.ExamSystem.domain.Teacher;
import com.aruiz.ExamSystem.entity.TeacherEntity;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter {

    // Method to convert a TeacherEntity object to a Teacher object
    // Método para convertir un objeto TeacherEntity a un objeto Teacher
    public Teacher toTeacher(TeacherEntity entity) {
        // ID is not assigned as it is automatically generated by the database
        // No se asigna un ID ya que es generado automáticamente por la base de datos
        return Teacher.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .age(entity.getAge())
                .phoneNumber(entity.getPhoneNumber())
                .role(entity.getRole())
                .img(entity.getImg())
                .build();

    }

    // Method to convert a TeacherRequest object to a TeacherEntity object
    // Método para convertir un objeto TeacherRequest a un objeto TeacherEntity
    public TeacherEntity toTeacherEntity(TeacherRequest request) {
        return TeacherEntity.builder()
                .id(null)
                .email(request.getEmail())
                .name(request.getName())
                .age(request.getAge())
                .phoneNumber(request.getPhoneNumber())
                .role(request.getRole())
                .img(request.getImg())
                .build();
    }

    // Method to convert a TeacherRequest object to a TeacherEntity object
    // Método para convertir un objeto TeacherRequest a un objeto TeacherEntity
    public TeacherEntity toTeacherEntity(Teacher teacher) {
        return TeacherEntity.builder()
                .id(null)
                .email(teacher.getEmail())
                .name(teacher.getName())
                .age(teacher.getAge())
                .phoneNumber(teacher.getPhoneNumber())
                .role(teacher.getRole())
                .img(teacher.getImg())
                .build();
    }

}
