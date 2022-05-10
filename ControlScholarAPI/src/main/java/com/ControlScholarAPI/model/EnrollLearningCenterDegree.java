package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class EnrollLearningCenterDegree {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private LearningCenterDegree learningCenterDegree;
    @OneToOne
    private Member member;
    private boolean finished;

    public EnrollLearningCenterDegree() {
    }

    public EnrollLearningCenterDegree(Integer id, LearningCenterDegree learningCenterDegree, Member member, boolean finished) {
        this.id = id;
        this.learningCenterDegree = learningCenterDegree;
        this.member = member;
        this.finished = finished;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LearningCenterDegree getLearningCenterDegree() {
        return learningCenterDegree;
    }

    public void setLearningCenterDegree(LearningCenterDegree learningCenterDegree) {
        this.learningCenterDegree = learningCenterDegree;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
