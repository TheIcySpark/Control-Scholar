package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class Semester {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Degree degree;

}
