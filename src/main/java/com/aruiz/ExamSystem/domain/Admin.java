package com.aruiz.ExamSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
}
