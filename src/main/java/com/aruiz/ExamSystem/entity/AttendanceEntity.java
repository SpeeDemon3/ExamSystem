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
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean attended;

    @ManyToOne
    @JoinColumn(name = "examId")
    private ExamEntity examEntity;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;

}
