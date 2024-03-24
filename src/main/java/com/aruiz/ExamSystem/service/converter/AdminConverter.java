package com.aruiz.ExamSystem.service.converter;

import com.aruiz.ExamSystem.controller.dtos.AdminRequest;
import com.aruiz.ExamSystem.domain.Admin;
import com.aruiz.ExamSystem.entity.AdminEntity;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {

    // Method to convert a AdminEntity object to a Admin object
    // Método para convertir un objeto AdminEntity a un objeto Admin
    public Admin toAdmin(AdminEntity adminEntity) {
        return Admin.builder()
                .id(adminEntity.getId())
                .email(adminEntity.getEmail())
                .name(adminEntity.getName())
                .phoneNumber(adminEntity.getPhoneNumber())
                .role(adminEntity.getRole())
                .build();
    }

    // Method to convert a AdminRequest object to a AdminEntity object
    // Método para convertir un objeto AdminRequest a un objeto AdminEntity
    public AdminEntity toAdminEntity(AdminRequest adminRequest) {
        return AdminEntity.builder()
                .id(null)
                .email(adminRequest.getEmail())
                .name(adminRequest.getName())
                .phoneNumber(adminRequest.getPhoneNumber())
                .role(adminRequest.getRole())
                .build();
    }

}
