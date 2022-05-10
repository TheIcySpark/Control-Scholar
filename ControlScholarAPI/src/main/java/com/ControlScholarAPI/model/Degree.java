package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class Degree {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public Degree() {
    }

    public Degree(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
