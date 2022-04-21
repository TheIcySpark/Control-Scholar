package com.ControlScholarAPI.service;

import com.ControlScholarAPI.model.Library;
import com.ControlScholarAPI.model.LibraryManager;
import com.ControlScholarAPI.repository.LibraryManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryManagerService {
    @Autowired
    private LibraryManagerRepo libraryManagerRepo;

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
