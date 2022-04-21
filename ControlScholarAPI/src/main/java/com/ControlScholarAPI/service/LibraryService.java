package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Library;
import com.ControlScholarAPI.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepo libraryRepo;

    public Library saveLibrary(Library library){
        return libraryRepo.save(library);
    }

    public List<Library> getLibraries(){
        return libraryRepo.findAll();
    }

    public void dropLibrary(Library library){
        libraryRepo.delete(library);
    }
}
