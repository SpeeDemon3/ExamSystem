package com.aruiz.ExamSystem.service.impl;

import com.aruiz.ExamSystem.controller.dtos.TeacherRequest;
import com.aruiz.ExamSystem.domain.Teacher;
import com.aruiz.ExamSystem.entity.TeacherEntity;
import com.aruiz.ExamSystem.repository.TeacherRepository;
import com.aruiz.ExamSystem.service.TeacherService;
import com.aruiz.ExamSystem.service.converter.TeacherConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherConverter teacherConverter;

    @Override
    public Teacher save(TeacherRequest teacherRequest) throws Exception {

        log.info("Saving teacher", teacherRequest);

        // Convert the teacher request object to a teacher entity
        // Convierte el objeto de solicitud de profesor a una entidad de profesor
        TeacherEntity teacherEntity = teacherConverter.toTeacherEntity(teacherRequest);
        log.info("Converted to entity: " + teacherEntity);

        // Save the teacher entity to the repository and get the saved entity
        // Guarda la entidad de profesor en el repositorio y obtiene la entidad guardada
        TeacherEntity saveTeacherEntity = teacherRepository.save(teacherEntity);
        log.info("Saved teacherEntity: " + saveTeacherEntity);

        // Converts the saved teacher entity to a teacher object and returns it
        // Convierte la entidad guardada de profesor a un objeto de profesor y lo devuelve
        return teacherConverter.toTeacher(saveTeacherEntity);
    }

    @Override
    public List<Teacher> findAll() throws Exception {
        // Retrieves all TeacherEntity entities from the database
        // Recupera todas las entidades TeacherEntity de la base de datos
        List<TeacherEntity> teacherList = teacherRepository.findAll();

        if(teacherList == null) {
            log.error("The teacher list is empty!!!");
            return null;
        }

        // Initialize a list to store converted teacher objects
        // Inicializa una lista para almacenar objetos profesor convertidos
        List<Teacher> teachers = new ArrayList<>();

        // Iterate over the list of entities and convert each entity to a Teacher object
        // Itera sobre la lista de entidades y convierte cada entidad a un objeto profesor
        teacherList.forEach(teacher -> teachers.add(teacherConverter.toTeacher(teacher)));

        // Returns the list of converted teacher objects
        // Devuelve la lista de objetos profesor convertidos
        return teachers;
    }

    @Override
    public Teacher findById(Long id) throws Exception {
        // Find the teacher entity corresponding to the given ID in the repository
        // Busca la entidad profesor correspondiente al ID proporcionado en el repositorio
        Optional<TeacherEntity> optionalTeacherEntity = teacherRepository.findById(id);

        if(optionalTeacherEntity.isPresent()) {
            log.info("Teacher is present");
            // Converts the entity to a domain object and returns it
            // Convierte la entidad en un objeto de dominio y lo devuelve
            return teacherConverter.toTeacher(optionalTeacherEntity.get());
        } else {
            throw new NoSuchElementException("Teacher not found with ID -> " + id);
        }
    }

    @Override
    public String deleteById(Long id) throws Exception {
        // Find the brand entity corresponding to the given ID in the repository
        // Busca la entidad de marca correspondiente al ID proporcionado en el repositorio
        Optional<TeacherEntity> teacherEntityOptional = teacherRepository.findById(id);

        if (teacherEntityOptional.isPresent()) {
            // Remove the entity from the repository
            // Elimina la entidad del repositorio
            teacherRepository.deleteById(id);

            return "Teacher with ID " + id + " was eliminated";
        } else {
            log.error("Id not found");
            throw new NoSuchElementException("Teacher not found with ID -> " + id);
        }

    }

    @Override
    public Teacher updateById(Long id, TeacherRequest teacherRequest) throws Exception {

        // Search the brand by ID in the repository
        // Busca la marca por ID en el repositorio
        Optional<TeacherEntity> optionalTeacherEntity = teacherRepository.findById(id);

        if (optionalTeacherEntity.isPresent()) {
            // Convert the domain object to an entity and save it to the repository
            // Convierte el objeto de dominio en una entidad y lo guarda en el repositorio
            TeacherEntity teacherEntity = teacherConverter.toTeacherEntity(teacherRequest);
            // Sets the ID given to the entity object before saving it
            // Establece el ID proporcionado al objeto de entidad antes de guardarlo
            teacherEntity.setId(id);

            // Convert the entity to domain and save the entity to the repository
            // Convierte la entidad a dominio y guarda la entidad en el repositorio
            return teacherConverter.toTeacher(teacherRepository.save(teacherEntity));

        } else {
            log.error("Id not found");
            throw new NoSuchElementException("Teacher not found with ID -> " + id);
        }

    }
}
