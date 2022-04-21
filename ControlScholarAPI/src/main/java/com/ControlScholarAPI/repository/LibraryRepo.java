package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Library, Integer> {
}
