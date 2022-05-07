package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.Book;
import com.ControlScholarAPI.model.BookCopies;
import com.ControlScholarAPI.model.LearningCenter;
import com.ControlScholarAPI.service.LearningCenterService;
import com.ControlScholarAPI.service.LibraryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraryManager")
public class LibraryManagerController {
    @Autowired
    private LibraryManagerService libraryManagerService;

    // Refactor with this later
    @Autowired
    private LearningCenterService learningCenterService;

    @PostMapping("/{center}/book/add")
    public ResponseEntity<Book>saveBook(@PathVariable String center, @RequestBody Book book){
        List<LearningCenter> a = learningCenterService.getLearningCenters();
        if(learningCenterService.isCenterInDatabase(center)){
            return ResponseEntity.ok().body(libraryManagerService.saveBook(book));
        }else{
            return (ResponseEntity<Book>) ResponseEntity.notFound();
        }
    }

    @GetMapping("/book/get/all")
    public ResponseEntity<List<Book>>getBooks(){
        return ResponseEntity.ok().body(libraryManagerService.getBooks());
    }

    @PostMapping("/{center}/bookCopies/add")
    public ResponseEntity<BookCopies> saveBookCopies(@PathVariable String center, @RequestBody BookCopies bookCopies){
        if(learningCenterService.isCenterInDatabase(center)){
            return ResponseEntity.ok().body(libraryManagerService.saveBookCopies(bookCopies));
        }else{
            return (ResponseEntity<BookCopies>) ResponseEntity.notFound();
        }
    }

    @GetMapping("/bookCopies/get/all")
    public ResponseEntity<List<BookCopies>> getBookCopies(){
        return ResponseEntity.ok().body(libraryManagerService.getBookCopies());
    }

}
