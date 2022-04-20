package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
    List<Book> findByName(String name);
}
