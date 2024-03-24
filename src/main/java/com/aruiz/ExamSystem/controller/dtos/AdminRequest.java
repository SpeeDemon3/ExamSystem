package com.aruiz.ExamSystem.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRequest {
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
}
