package com.aruiz.ExamSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteExam {
    private Long id;
    private Float nota;
    private Exam exam;
    private Student student;
    private Teacher teacher;

}
