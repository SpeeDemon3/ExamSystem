package com.aruiz.ExamSystem.controller;

import com.aruiz.ExamSystem.controller.dtos.TeacherRequest;
import com.aruiz.ExamSystem.controller.mapper.TeacherMapper;
import com.aruiz.ExamSystem.entity.TeacherEntity;
import com.aruiz.ExamSystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    public ResponseEntity<?> addTeacher(@RequestBody TeacherRequest teacherRequest) {

        try {
            log.info("Succesfully created user");
            // Save the teacher using the service
            // Guarda al profesor utlizando el servicio
            teacherService.save(teacherRequest);

            return ResponseEntity.ok().body(teacherRequest);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal server error");
        }

    }
    
}
