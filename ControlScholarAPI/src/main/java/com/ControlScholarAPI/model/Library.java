package com.ControlScholarAPI.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Library {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Book> books = new ArrayList<>();
    @OneToOne
    private LearningCenter learningCenter;

    public Library() {
    }

    public Library(int id, Collection<Book> books, LearningCenter learningCenter) {
        this.id = id;
        this.books = books;
        this.learningCenter = learningCenter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public LearningCenter getLearningCenter() {
        return learningCenter;
    }

    public void setLearningCenter(LearningCenter learningCenter) {
        this.learningCenter = learningCenter;
    }
}
