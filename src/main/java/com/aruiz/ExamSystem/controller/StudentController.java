package com.aruiz.ExamSystem.controller;

import com.aruiz.ExamSystem.controller.dtos.StudentRequest;
import com.aruiz.ExamSystem.controller.mapper.StudentMapper;
import com.aruiz.ExamSystem.domain.Student;
import com.aruiz.ExamSystem.entity.StudentEntity;
import com.aruiz.ExamSystem.service.StudentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequest studentRequest) {
        try {
            log.info("successfully created user");
            // Save the student using the service
            // Guarda al estudante utlizando el servicio
            studentServices.save(studentRequest);

            return ResponseEntity.ok().body(studentRequest);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Long id) {

        try {
            log.info("Looking for the student with ID -> ", id);

            // Searches for a student with the given ID using the service and wraps the result in an Optional
            // Busca un estudiante con el ID proporcionado utilizando el servicio y envuelve el resultado en un Optional
            Optional<Student> optionalStudent = Optional.ofNullable(studentServices.findById(id));

            // Check if the Optional contains a student
            // Verifica si el Optional contiene un estudiante
            if (optionalStudent.isPresent()) {
                // If the Optional contains a student, get the student and return a success response
                // with the student data converted to a StudentResponse
                // Si el Optional contiene un estudiante, obtén el estudiante y devuelve una respuesta exitosa
                // con los datos del estudiante convertidos a un StudentResponse
                Student student = optionalStudent.get();
                return ResponseEntity.ok().body(studentMapper.toStudentResponse(student));
            }

        } catch (Exception e) {
            //If an exception occurs, return an internal server error
            // Si se produce una excepción, devuelve un error interno del servidor
            return ResponseEntity.internalServerError().build();
        }

        // Records an error message in the log indicating that no student was found
        // with the given ID and returns a resource not found response
        // Registra un mensaje de error en el log indicando que no se encontró ningún estudiante
        // con el ID proporcionado y devuelve una respuesta de recurso no encontrado
        log.error("Student not found with ID " + id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok().body(studentServices.findAll());

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id) {
        try {
            log.info("Student with ID -> " + id + " successfully deleted");
            return ResponseEntity.ok().body(studentServices.deleteById(id));

        } catch (Exception e) {
            log.info("Student with ID -> " + id + " not found.");
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("updateById/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        try {
            return ResponseEntity.ok().body(studentServices.updateById(id, studentRequest));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}
