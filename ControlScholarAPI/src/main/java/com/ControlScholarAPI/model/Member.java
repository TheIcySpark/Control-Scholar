package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String name;
    private String pSurname;
    private String mSurname;
    private String email;
    private String password;
    private String type;
    @OneToOne
    private Library library;

    public Library getLibrary() {
        return library;
    }

    public Member() {
    }

    public Member(int id, String username, String name, String pSurname, String mSurname, String email, String password, String type) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.pSurname = pSurname;
        this.mSurname = mSurname;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getpSurname() {
        return pSurname;
    }

    public void setpSurname(String pSurname) {
        this.pSurname = pSurname;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String mSurname) {
        this.mSurname = mSurname;
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
