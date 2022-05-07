package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.EnrollSemester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollSemesterRepo extends JpaRepository<EnrollSemester, Integer> {
}
