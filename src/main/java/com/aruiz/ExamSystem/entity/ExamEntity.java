package com.aruiz.ExamSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor // Anotación para generar automáticamente un constructor con todos los argumentos
@Builder // Anotación para generar un constructor utilizando el patrón Builder
@NoArgsConstructor // Anotación para generar automáticamente un constructor sin argumentos
@Getter // Anotación para generar automáticamente getters para todos los campos
@Setter // Anotación para generar automáticamente setters para todos los campos
@ToString // Anotación para generar automáticamente el método toString()
@Entity // Anotación para indicar que esta clase es una entidad JPA
@Table(name = "exam") // Anotación para especificar el nombre de la tabla en la base de datos
public class ExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;
    private String dateExam;
    private Integer examDurationMinutes;
    private Double noteStudent;

    // Annotation to indicate the many-to-one relationship with the TeacherEntity entity,
    // mapped by the "teacherEntity" attribute on the TeacherEntity entity
    // Anotación para indicar la relación muchos a uno con la entidad TeacherEntity,
    // mapeada por el atributo "teacherEntity" en la entidad TeacherEntity
    @ManyToOne
    @JoinColumn(name = "teacherId")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity student;

}
