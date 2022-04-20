package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class LibraryManager {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String name;
    private String paSurname;
    private String maSurname;
    private String email;
    private String password;
    private String role;
    @OneToOne
    private Library library;


    public LibraryManager() {
    }

    public LibraryManager(int id, String username, String name, String paSurname, String maSurname, String email, String password, String role, Library library) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.paSurname = paSurname;
        this.maSurname = maSurname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.library = library;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
