package com.aruiz.ExamSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor // Anotación para generar automáticamente un constructor con todos los argumentos
@Builder // Anotación para generar un constructor utilizando el patrón Builder
@NoArgsConstructor // Anotación para generar automáticamente un constructor sin argumentos
@Getter // Anotación para generar automáticamente getters para todos los campos
@Setter // Anotación para generar automáticamente setters para todos los campos
@ToString // Anotación para generar automáticamente el método toString()
@Entity // Anotación para indicar que esta clase es una entidad JPA
@Table(name = "noteExam") // Anotación para especificar el nombre de la tabla en la base de datos
public class NoteExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float nota;

    // Annotation to indicate the many-to-one relationship with the ExamEntity entity,
    // mapped by the "entity" attribute on the NoteExamEntity entity
    // Anotación para indicar la relación muchos a uno con la entidad ExamEntity,
    // mapeada por el atributo "entity" en la entidad NoteExamEntity
    @ManyToOne
    @JoinColumn(name = "examId")
    private ExamEntity entity;

    // Annotation to indicate the many-to-one relationship with the StudentEntity entity,
    // mapped by the "studentEntity" attribute on the NoteExamEntity entity
    // Anotación para indicar la relación muchos a uno con la entidad StudentEntity,
    // mapeada por el atributo "studentEntity" en la entidad NoteExamEntity
    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;

    // Annotation to indicate the many-to-one relationship with the TeacherEntity entity,
    // mapped by the "teacherEntity" attribute on the NoteExamEntity entity
    // Anotación para indicar la relación muchos a uno con la entidad TeacherEntity,
    // mapeada por el atributo "teacherEntity" en la entidad NoteExamEntity
    @ManyToOne
    @JoinColumn(name = "teacherId")
    private TeacherEntity teacherEntity;



}
