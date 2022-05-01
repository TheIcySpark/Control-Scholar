package com.ControlScholarAPI.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Library {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<BookCopies> bookCopies = new ArrayList<>();
    @OneToOne
    private LearningCenter learningCenter;

    public Library() {
    }

    public Library(int id, Collection<BookCopies> booksCopies, LearningCenter learningCenter) {
        this.id = id;
        this.bookCopies = booksCopies;
        this.learningCenter = learningCenter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<BookCopies> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(Collection<BookCopies> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public LearningCenter getLearningCenter() {
        return learningCenter;
    }

    public void setLearningCenter(LearningCenter learningCenter) {
        this.learningCenter = learningCenter;
    }
}
