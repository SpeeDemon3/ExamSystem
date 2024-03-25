package com.aruiz.ExamSystem.controller;

import com.aruiz.ExamSystem.controller.dtos.AdminRequest;
import com.aruiz.ExamSystem.controller.mapper.AdminMapper;
import com.aruiz.ExamSystem.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    @PostMapping("/add")
    public ResponseEntity<?> addAdmin(@RequestBody AdminRequest adminRequest) {

        try {
            log.info("Succesfully created admin");
            adminService.save(adminRequest);
            return ResponseEntity.ok(adminRequest);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal server error");
        }

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllAdmin() {
        try {
            return ResponseEntity.ok(adminService.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(adminMapper.toAdminResponse(adminService.findById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(adminService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/uploadById/{id}")
    public ResponseEntity<?> uploadById(@PathVariable Long id, @RequestBody AdminRequest adminRequest) {
        try {
            return ResponseEntity.ok(adminService.updateById(id, adminRequest));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
