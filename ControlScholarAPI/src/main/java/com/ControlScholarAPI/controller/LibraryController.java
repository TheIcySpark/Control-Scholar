package com.ControlScholarAPI.controller;

import com.ControlScholarAPI.model.Library;
import com.ControlScholarAPI.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @PostMapping("/library/save")
    public ResponseEntity<Library> saveLibrary(@RequestBody Library library){
        return ResponseEntity.ok().body(libraryService.saveLibrary(library));
    }

    @GetMapping("/libraries")
    public ResponseEntity<List<Library>> getLibraries(){
        return ResponseEntity.ok().body(libraryService.getLibraries());
    }

    @DeleteMapping("/library/delete")
    public void dropLibrary(@RequestBody Library library){
        libraryService.dropLibrary(library);
    }
}
