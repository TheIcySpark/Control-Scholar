package com.ControlScholarAPI.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Semester {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer level;
    @OneToOne
    private Degree degree;

    public Semester() {
    }

    public Semester(Integer id, Integer level, Degree degree) {
        this.id = id;
        this.level = level;
        this.degree = degree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
