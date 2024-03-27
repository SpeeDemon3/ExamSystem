package com.aruiz.ExamSystem.controller.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

    private String email;
    private String name;
    private Integer age;
    private String phoneNumber;
    private String role;
    private String img;
}
