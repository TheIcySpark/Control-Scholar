package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.BookCopies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopiesRepo extends JpaRepository<BookCopies, Integer> {

}
