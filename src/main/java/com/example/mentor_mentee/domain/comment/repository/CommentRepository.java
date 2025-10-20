package com.example.mentor_mentee.domain.comment.repository;

import com.example.mentor_mentee.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
