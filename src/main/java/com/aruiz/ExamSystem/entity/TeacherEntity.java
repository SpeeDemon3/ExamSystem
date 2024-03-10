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
@Table(name = "teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private Integer age;
    private String phoneNumber;

    @OneToMany(mappedBy = "teacherEntity")
    private Set<ExamEntity> examEntities;

}
