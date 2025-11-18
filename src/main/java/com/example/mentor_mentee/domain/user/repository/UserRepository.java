package com.example.mentor_mentee.domain.user.repository;

import com.example.mentor_mentee.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
