package com.aruiz.ExamSystem.controller.dtos;

import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamRequest {
    private String subjectName;
    private String dateExam;
    private Integer examDurationMinutes;
    private Double noteStudent;
    private Long idTeacherEntity;
    private Long student;
}
