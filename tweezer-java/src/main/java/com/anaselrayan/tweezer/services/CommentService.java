package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.model.Comment;
import com.anaselrayan.tweezer.projection.CommentSummary;
import com.anaselrayan.tweezer.repos.CommentRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;

    public List<CommentSummary> getPostComments(Long postId) {
        return commentRepo.findAllByPostId(postId);
    }

    public Comment updateComment(@NonNull Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepo.save(comment);
    }

    public Comment addComment(@NonNull Comment comment) {
        comment.setUpdatedAt(LocalDateTime.now());
        return commentRepo.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepo.deleteById(commentId);
    }
}
