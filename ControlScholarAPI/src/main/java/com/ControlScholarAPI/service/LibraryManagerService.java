package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Book;
import com.ControlScholarAPI.model.BookCopies;
import com.ControlScholarAPI.model.Library;
import com.ControlScholarAPI.repository.BookCopiesRepo;
import com.ControlScholarAPI.repository.BookRepo;
import com.ControlScholarAPI.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryManagerService{
    @Autowired
    private BookCopiesRepo bookCopiesRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LibraryRepo libraryRepo;


    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public List<Book> getBook(String name){
        return (List<Book>) bookRepo.findByName(name);
    }

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public BookCopies saveBookCopies(BookCopies bookCopies){
        return bookCopiesRepo.save(bookCopies);
    }

    public List<BookCopies> getBookCopies(){
        return bookCopiesRepo.findAll();
    }

    public void dropBookCopies(BookCopies bookCopies){
        bookCopiesRepo.delete(bookCopies);
    }


    /**
    public Library saveLibrary(Library library){
        return libraryRepo.save(library);
    }

    public List<Library> getLibraries(){
        return libraryRepo.findAll();
    }

    public void dropLibrary(Library library) {
        libraryRepo.delete(library);
    }
     **/    
}
