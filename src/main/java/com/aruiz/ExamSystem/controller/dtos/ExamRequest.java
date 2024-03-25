package com.aruiz.ExamSystem.controller.dtos;

import com.aruiz.ExamSystem.entity.StudentEntity;
import com.aruiz.ExamSystem.entity.TeacherEntity;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private Long idTeacherEntity;
}
