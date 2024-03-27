package com.aruiz.ExamSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam {
    private Long id;
    private String subjectName;
    private String dateExam;
    private Integer examDurationMinutes;
    private Double noteStudent;
    private Teacher teacher;
    private  Student student;
}
