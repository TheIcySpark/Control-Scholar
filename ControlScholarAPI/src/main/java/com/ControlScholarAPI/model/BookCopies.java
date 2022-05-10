package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class BookCopies {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @OneToOne
    @JoinColumn(name = "learning_center_id")
    private LearningCenter learningCenter;
    private int copies;

    public LearningCenter getLearningCenter() {
        return learningCenter;
    }

    public Book getBook() {
        return book;
    }

    public BookCopies() {
    }

    public BookCopies(Integer id, Book book, LearningCenter learningCenter, int copies) {
        this.id = id;
        this.book = book;
        this.learningCenter = learningCenter;
        this.copies = copies;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
