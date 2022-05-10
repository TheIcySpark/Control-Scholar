package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Degree;
import com.ControlScholarAPI.model.LearningCenter;
import com.ControlScholarAPI.model.LearningCenterDegree;
import com.ControlScholarAPI.repository.DegreeRepo;
import com.ControlScholarAPI.repository.LearningCenterDegreeRepo;
import com.ControlScholarAPI.repository.LearningCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LearningCenterService {
    @Autowired
    private LearningCenterRepo learningCenterRepo;
    @Autowired
    private LearningCenterDegreeRepo learningCenterDegreeRepo;
    @Autowired
    private DegreeRepo degreeRepo;


    public LearningCenter saveLearningCenter(LearningCenter learningCenter){
        return learningCenterRepo.save(learningCenter);
    }

    public LearningCenter getLearningCenterById(int id){
        return learningCenterRepo.findById(id);
    }

    public LearningCenter getLearningCenterByLocation(String location){
        return learningCenterRepo.findByLocation(location);
    }

    public List<LearningCenter> getLearningCenters(){
        return learningCenterRepo.findAll();
    }

    public void dropLearningCenter(LearningCenter learningCenter){
        learningCenterRepo.delete(learningCenter);
    }

    public boolean isCenterInDatabase(String center){
        List<LearningCenter> learningCenters = learningCenterRepo.findAll();
        for(LearningCenter learningCenter: learningCenters){
            if(learningCenter.getLocation().equals(center)){
                return true;
            }
        }
        return false;
    }

    public Degree saveDegree(Degree degree){
        return degreeRepo.save(degree);
    }

    public List<Degree>getDegrees(){
        return degreeRepo.findAll();
    }

    public LearningCenterDegree saveLearningCenterDegree(LearningCenterDegree learningCenterDegree){
        return learningCenterDegreeRepo.save(learningCenterDegree);
    }


    public List<LearningCenterDegree> getLearningCenterDegreesByLearningCenter(LearningCenter learningCenter){
        List<LearningCenterDegree> r = new ArrayList<>();
        for (LearningCenterDegree i:learningCenterDegreeRepo.findAll()){
            if(i.getLearningCenter().getId() == learningCenter.getId()){
                r.add(i);
            }
        }
        return r;
    }
}
