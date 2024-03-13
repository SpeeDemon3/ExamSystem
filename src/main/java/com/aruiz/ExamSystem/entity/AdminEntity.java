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
@Table(name = "admin") // Anotación para especificar el nombre de la tabla en la base de datos
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String email;
    private String name;
    private String phoneNumber;
    private String role;

}
