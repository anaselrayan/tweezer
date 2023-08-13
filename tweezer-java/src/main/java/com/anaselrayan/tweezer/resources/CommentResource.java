package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.projection.CommentSummary;
import com.anaselrayan.tweezer.repos.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/comments/")
@RequiredArgsConstructor
public class CommentResource {
    private final CommentRepo commentRepo;

    @GetMapping("{postId}")
    public List<CommentSummary> getPostComments(@PathVariable Long postId) {
        return commentRepo.findAllByPostId(postId);
    }
}
