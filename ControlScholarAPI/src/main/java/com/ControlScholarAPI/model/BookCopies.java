package com.ControlScholarAPI.model;

import javax.persistence.*;

@Entity
public class BookCopies {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private int copies;

    public Book getBook() {
        return book;
    }

    public BookCopies() {
    }

    public BookCopies(Integer id, int copies) {
        this.id = id;
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
