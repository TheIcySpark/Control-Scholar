package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Book;
import com.ControlScholarAPI.model.Library;
import com.ControlScholarAPI.model.LibraryManager;
import com.ControlScholarAPI.repository.BookRepo;
import com.ControlScholarAPI.repository.LibraryManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LibraryManagerService{
    @Autowired
    private LibraryManagerRepo libraryManagerRepo;
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

    public LibraryManager saveLibraryManager(LibraryManager libraryManager){
        return libraryManagerRepo.save(libraryManager);
    }

    public List<LibraryManager> getLibrariesManagers(){
        return libraryManagerRepo.findAll();
    }

    public void dropLibraryManager(LibraryManager libraryManager){
        libraryManagerRepo.delete(libraryManager);
    }

}
