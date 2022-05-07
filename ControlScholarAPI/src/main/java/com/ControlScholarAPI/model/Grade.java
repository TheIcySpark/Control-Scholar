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

    public Member getMember() {
        return member;
    }

    public Subject getSubject() {
        return subject;
    }
}
