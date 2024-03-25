package com.aruiz.ExamSystem.repository;

import com.aruiz.ExamSystem.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Long> {
}
