package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
