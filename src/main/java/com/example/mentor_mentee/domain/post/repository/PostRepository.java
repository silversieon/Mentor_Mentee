package com.example.mentor_mentee.domain.post.repository;

import com.example.mentor_mentee.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
