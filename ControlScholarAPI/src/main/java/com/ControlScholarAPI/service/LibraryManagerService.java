package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Book;
import com.ControlScholarAPI.model.BookCopies;
import com.ControlScholarAPI.model.EnrollBookCopies;
import com.ControlScholarAPI.model.Library;
import com.ControlScholarAPI.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryManagerService {
    @Autowired
    private BookCopiesRepo bookCopiesRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private EnrollBookCopiesRepo enrollBookCopiesRepo;


    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getBook(String name) {
        return (List<Book>) bookRepo.findByName(name);
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    public BookCopies saveBookCopies(BookCopies bookCopies) {
        return bookCopiesRepo.save(bookCopies);
    }

    public List<BookCopies> getBookCopies() {
        return bookCopiesRepo.findAll();
    }

    public void dropBookCopies(BookCopies bookCopies) {
        bookCopiesRepo.delete(bookCopies);
    }

    public Library saveLibrary(Library library){
        return libraryRepo.save(library);
    }

    public List<Library> getLibraries(){
        return libraryRepo.findAll();
    }

    public void dropLibrary(Library library) {
        libraryRepo.delete(library);
    }

    public EnrollBookCopies saveEnrollBookCopies(EnrollBookCopies enrollBookCopies){
        return enrollBookCopiesRepo.save(enrollBookCopies);
    }

    public List<EnrollBookCopies>getEnrollBookCopies(){
        return enrollBookCopiesRepo.findAll();
    }

    public List<Book> getAllBooksByLearningCenter(String location){
        List<Book> r = new ArrayList<>();
        for (EnrollBookCopies i:enrollBookCopiesRepo.findAll()) {
            if(i.getLearningCenter().getLocation().equals(location)){
                r.add(i.getBookCopies().getBook());
            }
        }
        return r;
    }
}
