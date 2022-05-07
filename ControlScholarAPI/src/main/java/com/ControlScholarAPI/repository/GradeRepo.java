package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepo extends JpaRepository<Grade, Integer> {
}
