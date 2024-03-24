package com.aruiz.ExamSystem.controller.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRequest {
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
}
