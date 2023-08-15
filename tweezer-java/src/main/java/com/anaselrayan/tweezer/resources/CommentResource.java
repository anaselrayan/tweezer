package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.projection.CommentSummary;
import com.anaselrayan.tweezer.services.CommentService;
import com.anaselrayan.tweezer.shared.PaginationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments/")
@RequiredArgsConstructor
public class CommentResource {
    private final CommentService commentService;

    @GetMapping("{postId}")
    public Page<CommentSummary> getPostComments(@PathVariable Long postId,
                                                @RequestBody PaginationRequest pr) {
        return commentService.getPostComments(postId, pr);
    }
}
