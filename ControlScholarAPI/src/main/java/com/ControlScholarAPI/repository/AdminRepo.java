package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
