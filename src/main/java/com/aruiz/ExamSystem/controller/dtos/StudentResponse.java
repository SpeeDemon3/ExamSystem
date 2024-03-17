package com.aruiz.ExamSystem.controller.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {

    private Long id;
    private String email;
    private String name;
    private Integer age;
    private String phoneNumber;
    private String role;
    private String img;
}
