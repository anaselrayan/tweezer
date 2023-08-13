package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.Comment;
import com.anaselrayan.tweezer.projection.CommentSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<CommentSummary> findAllByPostId(Long postId);
}
