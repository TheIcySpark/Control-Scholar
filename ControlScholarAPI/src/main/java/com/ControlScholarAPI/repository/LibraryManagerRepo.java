package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.LibraryManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryManagerRepo extends JpaRepository<LibraryManager, Integer> {
    LibraryManager findByUsername(String username);
}
