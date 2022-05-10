package com.ControlScholarAPI.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Library {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private LearningCenter learningCenter;

    public Library() {
    }

    public Library(int id, LearningCenter learningCenter) {
        this.id = id;
        this.learningCenter = learningCenter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LearningCenter getLearningCenter() {
        return learningCenter;
    }

    public void setLearningCenter(LearningCenter learningCenter) {
        this.learningCenter = learningCenter;
    }
}
