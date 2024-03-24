package com.aruiz.ExamSystem.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {
    private Long id;
    private String email;
    private String name;
    private Integer age;
    private String phoneNumber;
    private String role;
    private String img;
}
