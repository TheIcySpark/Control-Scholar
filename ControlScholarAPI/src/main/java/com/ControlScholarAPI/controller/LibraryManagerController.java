package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.constant.LearningCenterLocations;
import com.ControlScholarAPI.model.*;
import com.ControlScholarAPI.service.LibraryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraryManager")
public class LibraryManagerController {
    @Autowired
    private LibraryManagerService libraryManagerService;

    @PostMapping("/{center}/book/add")
    public ResponseEntity<Book>saveBook(@PathVariable String center, @RequestBody Book book){
        if(LearningCenterLocations.checkIfLocation(center)){
            return ResponseEntity.ok().body(libraryManagerService.saveBook(book));
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/book/get/all")
    public ResponseEntity<List<Book>>getBooks(){
        return ResponseEntity.ok().body(libraryManagerService.getBooks());
    }

    @PostMapping("/{center}/bookCopies/add")
    public ResponseEntity<BookCopies> saveBookCopies(@PathVariable String center, @RequestBody BookCopies bookCopies){
        return ResponseEntity.ok().body(libraryManagerService.saveBookCopies(bookCopies));
    }

    @GetMapping("/bookCopies/get/all")
    public ResponseEntity<List<BookCopies>> getBookCopies(){
        return ResponseEntity.ok().body(libraryManagerService.getBookCopies());
    }

    @PostMapping("/{center}/library/add")
    public ResponseEntity<Library>saveLibrary(@RequestBody Library library){
        return ResponseEntity.ok().body(libraryManagerService.saveLibrary(library));
    }

}
