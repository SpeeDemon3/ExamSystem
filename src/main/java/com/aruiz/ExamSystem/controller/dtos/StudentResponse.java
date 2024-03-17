package com.aruiz.ExamSystem.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Long id;
    private String email;
    private String name;
    private Integer age;
    private String phoneNumber;
    private String role;
    private String img;
}
