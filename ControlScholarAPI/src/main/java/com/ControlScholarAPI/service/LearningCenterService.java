package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.LearningCenter;
import com.ControlScholarAPI.repository.LearningCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningCenterService {
    @Autowired
    private LearningCenterRepo learningCenterRepo;

    public LearningCenter saveLearningCenter(LearningCenter learningCenter){
        return learningCenterRepo.save(learningCenter);
    }

    public LearningCenter getLearningCenterById(int id){
        return learningCenterRepo.findById(id);
    }

    public List<LearningCenter> getLearningCenters(){
        return learningCenterRepo.findAll();
    }

    public void dropLearningCenter(LearningCenter learningCenter){
        learningCenterRepo.delete(learningCenter);
    }
}
