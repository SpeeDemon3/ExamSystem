package com.aruiz.ExamSystem.controller;

import com.aruiz.ExamSystem.controller.dtos.ExamRequest;
import com.aruiz.ExamSystem.controller.mapper.ExamMapper;
import com.aruiz.ExamSystem.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamMapper examMapper;

    @PostMapping("/add")
    public ResponseEntity<?> addExam(@RequestBody ExamRequest examRequest) {
        try {
            return ResponseEntity.ok(examMapper.toExamResponse(examService.save(examRequest)));
        } catch (Exception e) {
          return ResponseEntity.internalServerError().body("Internal server error");
        }
    }

}
