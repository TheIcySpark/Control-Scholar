package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.LearningCenter;
import com.ControlScholarAPI.repository.LearningCenterRepo;
import com.ControlScholarAPI.service.LearningCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LearningCenterController {
    @Autowired
    private LearningCenterService learningCenterService;

    @PostMapping("/learningCenter/add")
    public ResponseEntity<LearningCenter>saveLearningCenter(@RequestBody LearningCenter learningCenter){
        return ResponseEntity.ok().body(learningCenterService.saveLearningCenter(learningCenter));
    }

    @GetMapping("/learningCenter")
    public ResponseEntity<LearningCenter>getLearningCenterById(@RequestParam int id){
        return ResponseEntity.ok().body(learningCenterService.getLearningCenterById(id));
    }

    @GetMapping("/learningCenter/getAll")
    public ResponseEntity<List<LearningCenter>>getLearningCenters(){
        return ResponseEntity.ok().body(learningCenterService.getLearningCenters());
    }

    @DeleteMapping("/learningCenter/drop")
    public void dropLearningCenter(@RequestBody LearningCenter learningCenter){
        learningCenterService.dropLearningCenter(learningCenter);
    }
}
