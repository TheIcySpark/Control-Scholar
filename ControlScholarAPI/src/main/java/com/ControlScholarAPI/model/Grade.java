package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class Grade {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Member member;

    private float grade;

    public Grade() {
    }

    public Grade(Integer id, Subject subject, Member member) {
        this.id = id;
        this.subject = subject;
        this.member = member;
    }

    public Subject getSubject() {
        return subject;
    }

    public Member getMember() {
        return member;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
