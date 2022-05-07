package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepo extends JpaRepository<Semester, Integer> {
}
