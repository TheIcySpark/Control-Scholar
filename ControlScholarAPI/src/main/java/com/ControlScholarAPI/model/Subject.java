package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToOne
    private Semester semester;
    @OneToOne
    private Member member;

    public Subject() {
    }

    public Subject(Integer id, String name, Semester semester, Member member) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.member = member;
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

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public Semester getSemester() {
        return semester;
    }
}
