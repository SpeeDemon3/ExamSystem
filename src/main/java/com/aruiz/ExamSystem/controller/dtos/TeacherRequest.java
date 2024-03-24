package com.aruiz.ExamSystem.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {

    private String email;
    private String name;
    private Integer age;
    private String phoneNumber;
    private String role;
    private String img;

}
