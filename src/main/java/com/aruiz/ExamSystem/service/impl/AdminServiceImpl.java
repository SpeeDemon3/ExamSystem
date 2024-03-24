package com.aruiz.ExamSystem.service.impl;

import com.aruiz.ExamSystem.controller.dtos.AdminRequest;
import com.aruiz.ExamSystem.domain.Admin;
import com.aruiz.ExamSystem.entity.AdminEntity;
import com.aruiz.ExamSystem.repository.AdminRepository;
import com.aruiz.ExamSystem.service.AdminService;
import com.aruiz.ExamSystem.service.converter.AdminConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminConverter adminConverter;

    @Override
    public Admin save(AdminRequest adminRequest) throws Exception {

        if(adminRequest.getEmail() != null) {

            AdminEntity adminEntity = adminConverter.toAdminEntity(adminRequest);

            return adminConverter.toAdmin(adminRepository.save(adminEntity));
        }

        return null;
    }

    @Override
    public List<Admin> findAll() throws Exception {
        return null;
    }

    @Override
    public Admin findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) throws Exception {
        return null;
    }

    @Override
    public Admin updateById(Long id, AdminRequest adminRequest) throws Exception {
        return null;
    }
}
