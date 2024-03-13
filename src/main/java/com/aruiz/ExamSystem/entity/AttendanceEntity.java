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
@Table(name = "attendance") // Anotación para especificar el nombre de la tabla en la base de datos
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
