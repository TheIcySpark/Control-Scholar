package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class EnrollSemester {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int year;
    @OneToOne
    private Semester semester;
    @OneToOne
    private Member member;
}
