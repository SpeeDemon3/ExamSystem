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
@Table(name = "teacher") // Anotación para especificar el nombre de la tabla en la base de datos
public class TeacherEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private Integer age;
    private String phoneNumber;
    private String role;
    private String img;

    // Annotation to indicate the one-to-many relationship with the ExamEntity entity,
    // mapped by the "teacherEntity" attribute on the ExamEntity entity
    // Anotación para indicar la relación uno a muchos con la entidad ExamEntity,
    // mapeada por el atributo "teacherEntity" en la entidad ExamEntity
    @OneToMany(mappedBy = "teacherEntity")
    private List<ExamEntity> examEntities;

}
