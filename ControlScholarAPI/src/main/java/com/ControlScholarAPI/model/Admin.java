package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String paSurname;
    private String maSurname;
    private String email;
    private String role;
    @ManyToOne
    @JoinColumn(name = "learning_center_id")
    private LearningCenter learningCenter;

    public Admin() {
    }

    public Admin(int id, LearningCenter learningCenter, String name, String paSurname, String maSurname, String email, String role) {
        this.id = id;
        this.learningCenter = learningCenter;
        this.name = name;
        this.paSurname = paSurname;
        this.maSurname = maSurname;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLearningCenter(LearningCenter learningCenter) {
        this.learningCenter = learningCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaSurname() {
        return paSurname;
    }

    public void setPaSurname(String paSurname) {
        this.paSurname = paSurname;
    }

    public String getMaSurname() {
        return maSurname;
    }

    public void setMaSurname(String maSurname) {
        this.maSurname = maSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LearningCenter getLearningCenter() {
        return learningCenter;
    }
}
