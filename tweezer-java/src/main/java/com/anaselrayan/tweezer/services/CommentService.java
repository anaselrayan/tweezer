package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.model.Comment;
import com.anaselrayan.tweezer.projection.CommentSummary;
import com.anaselrayan.tweezer.repos.CommentRepo;
import com.anaselrayan.tweezer.shared.PaginationRequest;
import com.anaselrayan.tweezer.shared.PaginationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;

    public Page<CommentSummary> getPostComments(Long postId, PaginationRequest pr) {
        Pageable pageable = PaginationService.getPageable(pr);
        return commentRepo.findAllByPostId(postId, pageable);
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
