package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class EnrollBookCopies {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_copies_id")
    private BookCopies bookCopies;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "learning_center_id")
    private LearningCenter learningCenter;

    public EnrollBookCopies() {

    }

    public EnrollBookCopies(Integer id, BookCopies bookCopies, LearningCenter learningCenter) {
        this.id = id;
        this.bookCopies = bookCopies;
        this.learningCenter = learningCenter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookCopies getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(BookCopies bookCopies) {
        this.bookCopies = bookCopies;
    }

    public LearningCenter getLearningCenter() {
        return learningCenter;
    }

    public void setLearningCenter(LearningCenter learningCenter) {
        this.learningCenter = learningCenter;
    }
}
