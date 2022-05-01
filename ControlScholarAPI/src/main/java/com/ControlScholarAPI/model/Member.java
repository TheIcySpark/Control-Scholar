package com.ControlScholarAPI.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String name;
    private String paSurname;
    private String maSurname;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "learning_center_id")
    private LearningCenter learningCenter;

    public LearningCenter getLearningCenter() {
        return learningCenter;
    }


    public Member() {
    }

    public Member(int id, String username, String name, String pSurname, String mSurname, String email, String password, String type) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.paSurname = pSurname;
        this.maSurname = mSurname;
        this.email = email;
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void setLearningCenter(LearningCenter learningCenter) {
        this.learningCenter = learningCenter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
