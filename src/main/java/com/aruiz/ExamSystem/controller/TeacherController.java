package com.aruiz.ExamSystem.controller;

import com.aruiz.ExamSystem.controller.dtos.TeacherRequest;
import com.aruiz.ExamSystem.controller.dtos.TeacherResponse;
import com.aruiz.ExamSystem.controller.mapper.TeacherMapper;
import com.aruiz.ExamSystem.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    @PostMapping("/add")
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

    @GetMapping("/findById/{id}")
    public ResponseEntity<TeacherResponse> findById(@PathVariable Long id) {
        try {
            TeacherResponse teacherResponse = teacherMapper.toTeacherResponse(teacherService.findById(id));

            return ResponseEntity.ok().body(teacherResponse);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllTeacher() {
        try {
            return ResponseEntity.ok(teacherService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable Long id) {
        try {
            teacherService.deleteById(id);
            return ResponseEntity.ok("Teacher eliminated with ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<TeacherResponse> updateTeacherById(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        try {
            teacherService.updateById(id, teacherRequest);

            return ResponseEntity.ok(teacherMapper.toTacherResponse(teacherRequest));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}
