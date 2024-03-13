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
@Table(name = "student") // Anotación para especificar el nombre de la tabla en la base de datos
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private Integer age;
    private String phoneNumber;
    private String role;
    private String img;

    // Annotation to indicate the many-to-many relationship with the ExamEntity entity,
    // mapped by the "studentEntities" attribute on the ExamEntity entity
    // Anotación para indicar la relación muchos a muchos con la entidad ExamEntity,
    // mapeada por el atributo "studentEntities" en la entidad ExamEntity
    @ManyToMany(mappedBy = "studentEntities")
    private List<ExamEntity> exams;


}
