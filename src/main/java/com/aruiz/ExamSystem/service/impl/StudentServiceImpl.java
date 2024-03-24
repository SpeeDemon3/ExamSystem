package com.aruiz.ExamSystem.service.impl;

import com.aruiz.ExamSystem.controller.dtos.StudentRequest;
import com.aruiz.ExamSystem.domain.Student;
import com.aruiz.ExamSystem.entity.StudentEntity;
import com.aruiz.ExamSystem.repository.StudentRepository;
import com.aruiz.ExamSystem.service.StudentServices;
import com.aruiz.ExamSystem.service.converter.StudentConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentConverter studentConverter;

    @Override
    public Student save(StudentRequest studentRequest) throws Exception {

        log.info("Saving student: ", studentRequest);

        // Convert the student request object to a student entity
        // Convierte el objeto de solicitud de estudiante a una entidad de estudiante
        StudentEntity studentEntity = studentConverter.toStudentEntity(studentRequest);
        log.info("Converted to entity: ", studentEntity);

        // Save the student entity to the repository and get the saved entity
        // Guarda la entidad de estudiante en el repositorio y obtiene la entidad guardada
        StudentEntity saveStudentEntity = studentRepository.save(studentEntity);
        log.info("Saved studentEntity: ", saveStudentEntity);

        // Converts the saved student entity to a student object and returns it
        // Convierte la entidad guardada de estudiante a un objeto de estudiante y lo devuelve
        return studentConverter.toStudent(saveStudentEntity);
    }

    @Override
    public List<Student> findAll() throws Exception {

        // Retrieves all StudentEntity entities from the database
        // Recupera todas las entidades StudentEntity de la base de datos
        List<StudentEntity> studentList = studentRepository.findAll();

        if (studentList == null) {
            log.error("The student list is empty!!!");
            return null;
        }

        // Initialize a list to store converted student objects
        // Inicializa una lista para almacenar objetos estudiante convertidos
        List<Student> students = new ArrayList<>();

        // Iterate over the list of entities and convert each entity to a student object
        // Itera sobre la lista de entidades y convierte cada entidad a un objeto de estudiante
        studentList.forEach(student -> students.add(studentConverter.toStudent(student)));

        // Returns the list of converted student objects
        // Devuelve la lista de objetos de estudiante convertidos
        return students;
    }

    @Override
    public Student findById(Long id) throws Exception {
        // Find the student entity corresponding to the given ID in the repository
        // Busca la entidad de estudiante correspondiente al ID proporcionado en el repositorio
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);

        if (optionalStudentEntity.isPresent()) {
            log.info("Student is present");
            // Converts the entity to a domain object and returns it
            // Convierte la entidad en un objeto de dominio y lo devuelve
            return studentConverter.toStudent(optionalStudentEntity.get());
        }

        return null;
    }

    @Override
    public String deleteById(Long id) throws Exception {

        // Try to find a StudentEntity by its ID in the database
        // Intenta encontrar una entidad StudentEntity por su ID en la base de datos
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);

        // Check if the StudentEntity entity is present in the database
        // Verifica si la entidad StudentEntity está presente en la base de datos
        if (optionalStudentEntity.isPresent()) {
            // If present, deletes the entity with the given ID
            // Si está presente, elimina la entidad con el ID proporcionado
            studentRepository.deleteById(id);
            return "Student succesfully eliminated";
        } else {
            throw  new NoSuchFieldException("Student with ID -> " + id + " not found");
        }

    }

    @Override
    public Student updateById(Long id, StudentRequest studentRequest) throws Exception {
        // Search the student by ID in the repository
        // Busca el estudiante por ID en el repositorio
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);

        if (optionalStudentEntity.isPresent()) {
            // Convert the domain object to an entity and save it to the repository
            // Convierte el objeto de dominio en una entidad y lo guarda en el repositorio
            StudentEntity studentEntity = studentConverter.toStudentEntity(studentRequest);
            // Sets the ID given to the entity object before saving it
            // Establece el ID proporcionado al objeto de entidad antes de guardarlo
            studentEntity.setId(id);

            // Save the entity to the repository
            // Guarda la entidad en el repositorio
            studentRepository.save(studentEntity);

            return studentConverter.toStudent(studentEntity);
        } else {
            log.error("ID not found");
            throw new NoSuchElementException("Student not found with ID -> " + id);
        }


    }


}
