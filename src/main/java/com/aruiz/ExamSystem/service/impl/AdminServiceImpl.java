package com.aruiz.ExamSystem.service.impl;

import com.aruiz.ExamSystem.controller.dtos.AdminRequest;
import com.aruiz.ExamSystem.domain.Admin;
import com.aruiz.ExamSystem.entity.AdminEntity;
import com.aruiz.ExamSystem.repository.AdminRepository;
import com.aruiz.ExamSystem.service.AdminService;
import com.aruiz.ExamSystem.service.converter.AdminConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminConverter adminConverter;

    @Override
    public Admin save(AdminRequest adminRequest) throws Exception {

            log.info("Succesfully created admin");

            AdminEntity adminEntity = adminRepository.save(adminConverter.toAdminEntity(adminRequest));

            log.info("Entity ID {}", adminEntity.getId());

            return adminConverter.toAdmin(adminEntity);

    }

    @Override
    public List<Admin> findAll() throws Exception {

        List<AdminEntity> adminEntityList = adminRepository.findAll();

        if (!adminEntityList.isEmpty()) {

            List<Admin> adminList = new ArrayList<>();

            adminEntityList.forEach(admin -> adminList.add(adminConverter.toAdmin(admin)));

            return adminList;

        } else {
            throw  new EmptyResultDataAccessException("No entities found", 1);
        }

    }

    @Override
    public Admin findById(Long id) throws Exception {

        Optional<AdminEntity> optionalAdminEntity = adminRepository.findById(id);

        if (optionalAdminEntity.isPresent()) {
            AdminEntity adminEntity = optionalAdminEntity.get();
            return adminConverter.toAdmin(adminEntity);
        } else {
            throw new NoSuchElementException("Admin not found with ID -> " + id);
        }

    }

    @Override
    public Boolean deleteById(Long id) throws Exception {

        Optional<AdminEntity> adminEntityOptional = adminRepository.findById(id);

        if (adminEntityOptional.isPresent()) {
            adminRepository.deleteById(id);
            return true;
        } else {
            throw new NoSuchElementException("Admin not found with ID -> " + id);
        }

    }

    @Override
    public Admin updateById(Long id, AdminRequest adminRequest) throws Exception {

        Optional<AdminEntity> adminEntityOptional = adminRepository.findById(id);

        if (adminEntityOptional.isPresent()) {
            AdminEntity admin = adminEntityOptional.get();

            AdminEntity adminEntitySave = adminConverter.toAdminEntity(adminRequest);
            adminEntitySave.setId(id);

            return adminConverter.toAdmin(adminEntitySave);

        } else {
            throw new NoSuchElementException("Admin not found with ID -> " + id);
        }

    }
}
