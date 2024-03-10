package com.aruiz.ExamSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "exam")
public class ExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;
    private String dateExam;
    private Integer examDurationMinutes;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private TeacherEntity teacherEntity;

    @ManyToMany
    @JoinTable(
            name = "attendance",
            joinColumns = @JoinColumn(name = "examId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )
    private Set<StudentEntity> studentEntities;

}
