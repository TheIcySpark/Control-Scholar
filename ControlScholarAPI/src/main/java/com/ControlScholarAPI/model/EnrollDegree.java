package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class EnrollDegree {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Degree degree;
    @OneToOne
    private Member member;

    public Member getMember() {
        return member;
    }

    public Degree getDegree() {
        return degree;
    }
}
