package com.aruiz.ExamSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "noteExam")
public class NoteExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float nota;

    @ManyToOne
    @JoinColumn(name = "examId")
    private ExamEntity entity;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private TeacherEntity teacherEntity;



}
