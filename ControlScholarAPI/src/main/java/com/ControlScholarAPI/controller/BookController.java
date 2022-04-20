package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.Book;
import com.ControlScholarAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/book/add")
    public ResponseEntity<Book>saveBook(@RequestBody Book book){
        return ResponseEntity.ok().body(bookService.saveBook(book));
    }

    @GetMapping("/book/get/all")
    public ResponseEntity<List<Book>>getBooks(){
        return ResponseEntity.ok().body(bookService.getBooks());
    }

    @GetMapping("/book/get")
    public ResponseEntity<List<Book>>getBook(@RequestParam String name){
        return ResponseEntity.ok().body(bookService.getBook(name));
    }
}
