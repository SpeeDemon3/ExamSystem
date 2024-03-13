package com.aruiz.ExamSystem.domain;

import com.aruiz.ExamSystem.entity.StudentEntity;
import com.aruiz.ExamSystem.entity.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam {
    private Long id;
    private String subjectName;
    private String dateExam;
    private Integer examDurationMinutes;
    private TeacherEntity teacherEntity;
    private List<StudentEntity> studentEntities;

}
