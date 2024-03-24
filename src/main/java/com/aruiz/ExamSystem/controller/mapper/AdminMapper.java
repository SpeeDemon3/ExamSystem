package com.aruiz.ExamSystem.controller.mapper;

import com.aruiz.ExamSystem.controller.dtos.AdminRequest;
import com.aruiz.ExamSystem.controller.dtos.AdminResponse;
import com.aruiz.ExamSystem.domain.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AdminMapper {

    // Method to convert a Admin object to a AdminResponse object
    // Método para convertir un objeto Admin a un objeto AdminResponse
    public AdminResponse toAdminResponse(Admin admin) {

        if (admin.getId() != null) {
            return AdminResponse.builder()
                    .id(admin.getId())
                    .email(admin.getEmail())
                    .name(admin.getName())
                    .phoneNumber(admin.getPhoneNumber())
                    .role(admin.getRole())
                    .build();
        } else {
            log.error("Admin is empty");
            return null;
        }

    }

    // Method to convert a AdminRequest object to a AdminResponse object
    // Método para convertir un objeto AdminRequest a un objeto AdminResponse
    public AdminResponse toAdminResponse(AdminRequest adminRequest) {

        if (adminRequest.getEmail() != null) {
            return AdminResponse.builder()
                    .id(null)
                    .email(adminRequest.getEmail())
                    .name(adminRequest.getName())
                    .phoneNumber(adminRequest.getPhoneNumber())
                    .role(adminRequest.getRole())
                    .build();
        } else {
            log.error("Admin is empty");
            return null;
        }

    }

    public Admin toAdminModel(AdminRequest adminRequest) {
        return Admin.builder()
                .id(null)
                .email(adminRequest.getEmail())
                .name(adminRequest.getName())
                .phoneNumber(adminRequest.getPhoneNumber())
                .role(adminRequest.getRole())
                .build();
    }

}
