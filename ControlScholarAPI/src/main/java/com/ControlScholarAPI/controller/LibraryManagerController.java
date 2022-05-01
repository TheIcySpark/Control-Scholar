package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.Book;
import com.ControlScholarAPI.model.LibraryManager;
import com.ControlScholarAPI.service.LibraryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryManagerController {
    @Autowired
    private LibraryManagerService libraryManagerService;

    @PostMapping("/libraryManager/save")
    public ResponseEntity<LibraryManager> saveLibraryManager(@RequestBody LibraryManager libraryManager){
        return ResponseEntity.ok().body(libraryManagerService.saveLibraryManager(libraryManager));
    }

    @GetMapping("/librariesManager/get/all")
    public ResponseEntity<List<LibraryManager>> getLibrariesManagers(){
        return ResponseEntity.ok().body(libraryManagerService.getLibrariesManagers());
    }

    @DeleteMapping("/libraryManager/drop")
    public void dropLibraryManager(@RequestBody LibraryManager libraryManager){
        libraryManagerService.dropLibraryManager(libraryManager);
    }

}
