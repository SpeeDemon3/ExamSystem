package com.aruiz.ExamSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Long id;
    private String email;
    private String name;
    private Integer age;
    private String phoneNumber;
    private String role;
    private String img;
    private List<Exam> exams;

}
