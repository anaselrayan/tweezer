package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.dao.CommentDao;
import com.anaselrayan.tweezer.dto.CommentDto;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;

    public PageableResponse<CommentDto> getPostComments(Long postId, PageRequest pr) {
        return commentDao.selectPostComments(postId, pr);
    }

    public void addComment(@NonNull CommentDto comment) {
        comment.createdAt = LocalDateTime.now();
        comment.updatedAt = LocalDateTime.now();
        commentDao.insertComment(comment.content, comment.createdAt,
                                         comment.updatedAt, comment.postId,
                                         comment.profile.profileId);
    }
}
