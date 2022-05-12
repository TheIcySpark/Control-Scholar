package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.constant.LearningCenterLocations;
import com.ControlScholarAPI.model.*;
import com.ControlScholarAPI.service.LearningCenterService;
import com.ControlScholarAPI.service.LibraryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryManagerController {
    @Autowired
    private LibraryManagerService libraryManagerService;
    @Autowired
    private LearningCenterService learningCenterService;

    @PostMapping("/libraryManager/book/add")
    public ResponseEntity<Book>saveBook(@RequestBody Book book){
        return ResponseEntity.ok().body(libraryManagerService.saveBook(book));
    }

    @DeleteMapping("/libraryManager/book/drop")
    public void dropBook(@RequestBody Book book){
        libraryManagerService.dropBook(book);
    }


    @PostMapping("/libraryManager/{center}/bookCopies/add")
    public ResponseEntity<BookCopies>saveBookCopies(@PathVariable String center, @RequestBody BookCopies bookCopies){
        if(LearningCenterLocations.checkIfLocation(center)){
            bookCopies.setLearningCenter(learningCenterService.getLearningCenterByLocation(center));
            return ResponseEntity.ok().body(libraryManagerService.saveBookCopies(bookCopies));
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/libraryManager/{center}/bookCopies/get/all")
    public ResponseEntity<List<BookCopies>>getBookCopiesFromCenter(@PathVariable String center){
        return ResponseEntity.ok().body(libraryManagerService.getBookCopiesFromCenter(center));
    }

    @GetMapping("/libraryManager/book/get/all")
    public ResponseEntity<List<Book>>getBooks(){
        return ResponseEntity.ok().body(libraryManagerService.getBooks());
    }

    @GetMapping("/bookCopies/get/all")
    public ResponseEntity<List<BookCopies>> getBookCopies(){
        return ResponseEntity.ok().body(libraryManagerService.getBookCopies());
    }

}
