package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Degree;
import com.ControlScholarAPI.model.Semester;
import com.ControlScholarAPI.model.Subject;
import com.ControlScholarAPI.repository.DegreeRepo;
import com.ControlScholarAPI.repository.GradeRepo;
import com.ControlScholarAPI.repository.SemesterRepo;
import com.ControlScholarAPI.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeService {
    @Autowired
    private DegreeRepo degreeRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private SemesterRepo semesterRepo;

    public Semester saveSemester(Semester semester){
        return semesterRepo.save(semester);
    }

    public Degree saveDegree(Degree degree){
        return degreeRepo.save(degree);
    }

    public Subject saveSubject(Subject subject){
        return subjectRepo.save(subject);
    }

}
