package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.projection.UserPostSummary;
import com.anaselrayan.tweezer.services.PaginationService;
import com.anaselrayan.tweezer.services.UserPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts")
public class UserPostResource {
    private final UserPostService postService;

    @GetMapping("{profileId}")
    public Page<UserPostSummary> getAllPostsForProfile(@PathVariable Long profileId,
                                                       @RequestParam Integer page,
                                                       @RequestParam(required = false) Integer size) {
        return postService.getAllPostsForProfile(profileId, PaginationService.getPageable(page, size));
    }


    @PostMapping
    public void addPost(@RequestBody UserPost post) {
        postService.createUserPost(post);
    }

    @DeleteMapping("{postId}")
    public void deleteUserPost(@PathVariable Long postId) {
        postService.deleteUserPost(postId);
    }
}
