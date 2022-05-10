package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.LearningCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningCenterRepo extends JpaRepository<LearningCenter, Integer> {
    LearningCenter findById(int id);
    LearningCenter findByLocation(String location);
}
