package com.aruiz.ExamSystem.service;

import com.aruiz.ExamSystem.controller.dtos.AdminRequest;
import com.aruiz.ExamSystem.domain.Admin;

import java.util.List;

public interface AdminService {

    Admin save(AdminRequest adminRequest) throws Exception;

    List<Admin> findAll() throws Exception;

    Admin findById(Long id) throws Exception;

    Boolean deleteById(Long id)  throws Exception;

    Admin updateById(Long id, AdminRequest adminRequest)  throws Exception;

}
