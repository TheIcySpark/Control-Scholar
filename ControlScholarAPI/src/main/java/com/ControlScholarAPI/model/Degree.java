package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class Degree {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;


}
