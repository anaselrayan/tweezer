package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.Comment;
import com.anaselrayan.tweezer.projection.CommentSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepo extends JpaRepository<Comment, Long> {

    Page<CommentSummary> findAllByPostId(Long postId, Pageable pageable);
}
