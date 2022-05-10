package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.Degree;
import com.ControlScholarAPI.model.Semester;
import com.ControlScholarAPI.model.Subject;
import com.ControlScholarAPI.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/degree")
public class DegreeController {
    @Autowired
    private DegreeService degreeService;
    @PostMapping("{center}/add")
    public ResponseEntity<Degree>saveDegree(Degree degree){
        return ResponseEntity.ok().body(degreeService.saveDegree(degree));
    }

    @PostMapping("{center}/semester/add")
    public ResponseEntity<Semester>saveSemester(Semester semester){
        return ResponseEntity.ok().body(degreeService.saveSemester(semester));
    }

    @PostMapping("{center}/subject/add")
    public ResponseEntity<Subject>saveSubject(Subject subject){
        return  ResponseEntity.ok().body(degreeService.saveSubject(subject));
    }

}
