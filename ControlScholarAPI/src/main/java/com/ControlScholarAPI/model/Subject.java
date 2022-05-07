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

    public Member getMember() {
        return member;
    }

    public Semester getSemester() {
        return semester;
    }
}
