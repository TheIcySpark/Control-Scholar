package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Book;
import com.ControlScholarAPI.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public List<Book> getBook(String name){
        return (List<Book>) bookRepo.findByName(name);
    }

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

}
