package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepo extends JpaRepository<Degree, Integer> {
}
