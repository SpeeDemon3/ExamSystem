package com.aruiz.ExamSystem.controller.dtos;

import com.aruiz.ExamSystem.domain.Teacher;
import com.aruiz.ExamSystem.entity.TeacherEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ExamResponse {
    private Long id;
    private String subjectName;
    private String dateExam;
    private Integer examDurationMinutes;
    private Teacher teacherEntity;
}
