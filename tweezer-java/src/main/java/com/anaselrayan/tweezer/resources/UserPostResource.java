package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.projection.UserPostSummary;
import com.anaselrayan.tweezer.services.UserPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts")
public class UserPostResource {
    private final UserPostService postService;
    @GetMapping("{profileId}")
    public List<UserPostSummary> getAllPostsForUser(@PathVariable Long profileId) {
        return postService.getAllPostsForProfile(profileId);
    }

    @PostMapping
    public UserPost addPost(@RequestBody UserPost post) {
        return postService.addUserPost(post);
    }

    @DeleteMapping("{postId}")
    public void deleteUserPost(@PathVariable Long postId) {
        postService.deleteUserPost(postId);
    }
}
