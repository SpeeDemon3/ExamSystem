package com.aruiz.ExamSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {
    private Long id;
    private Boolean attended;
    private Exam exam;
    private Student student;
}
