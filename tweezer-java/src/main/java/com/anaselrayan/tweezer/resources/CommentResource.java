package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.dto.CommentDto;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import com.anaselrayan.tweezer.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
@RequiredArgsConstructor
public class CommentResource {
    private final CommentService commentService;

    @GetMapping("{postId}")
    public PageableResponse<CommentDto> getPostComments(@PathVariable Long postId,
                                                        @RequestParam Integer page,
                                                        @RequestParam(required = false) Integer size) {
        var pr = new PageRequest(page, size);
        return commentService.getPostComments(postId, pr);
    }


    @PostMapping
    public void addComment(@RequestBody CommentDto comment) {
        commentService.addComment(comment);
    }
}
