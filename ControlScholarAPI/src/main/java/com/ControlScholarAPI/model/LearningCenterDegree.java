package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class LearningCenterDegree {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private LearningCenter learningCenter;
    @OneToOne
    private Degree degree;

    public LearningCenterDegree() {
    }

    public LearningCenterDegree(Integer id, LearningCenter learningCenter, Degree degree) {
        this.id = id;
        this.learningCenter = learningCenter;
        this.degree = degree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LearningCenter getLearningCenter() {
        return learningCenter;
    }

    public void setLearningCenter(LearningCenter learningCenter) {
        this.learningCenter = learningCenter;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
