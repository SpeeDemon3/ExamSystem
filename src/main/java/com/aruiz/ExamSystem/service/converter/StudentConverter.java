package com.aruiz.ExamSystem.service.converter;

import com.aruiz.ExamSystem.controller.dtos.StudentRequest;
import com.aruiz.ExamSystem.domain.Student;
import com.aruiz.ExamSystem.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    // Method to convert a StudentEntity object to a Student object
    // Método para convertir un objeto StudentEntity a un objeto Student
    public Student toStudent(StudentEntity studentEntity) {
        return Student.builder()
                // ID is not assigned as it is automatically generated by the database
                // No se asigna un ID ya que es generado automáticamente por la base de datos
                .id(studentEntity.getId())
                .email(studentEntity.getEmail())
                .name(studentEntity.getEmail())
                .age(studentEntity.getAge())
                .phoneNumber(studentEntity.getPhoneNumber())
                .role(studentEntity.getRole())
                .img(studentEntity.getImg())
                .build();
    }

    // Method to convert a StudentRequest object to a StudentEntity object
    // Método para convertir un objeto StudentRequest a un objeto StudentEntity
    public StudentEntity toStudentEntity(StudentRequest studentRequest) {
        return StudentEntity.builder()
                .id(null)
                .email(studentRequest.getEmail())
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .phoneNumber(studentRequest.getPhoneNumber())
                .role(studentRequest.getRole())
                .img(studentRequest.getImg())
                .build();
    }

}