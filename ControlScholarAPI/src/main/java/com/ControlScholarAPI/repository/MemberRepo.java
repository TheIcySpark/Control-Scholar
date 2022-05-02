package com.ControlScholarAPI.repository;

import com.ControlScholarAPI.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Integer> {
    Member getById(Integer id);
}
