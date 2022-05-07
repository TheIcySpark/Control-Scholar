package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {
}
