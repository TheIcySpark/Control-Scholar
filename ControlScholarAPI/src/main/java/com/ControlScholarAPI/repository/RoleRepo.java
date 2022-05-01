package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
