package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.services.UserPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts")
public class UserPostResource {
    private final UserPostService postService;
    @GetMapping("all")
    public List<UserPost> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("{postId}")
    public UserPost getUserPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
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
