package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.projection.UserPostSummary;
import com.anaselrayan.tweezer.services.UserPostService;
import com.anaselrayan.tweezer.shared.PaginationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts")
public class UserPostResource {
    private final UserPostService postService;

//    @GetMapping("{profileId}")
//    public List<UserPostSummary> getAllPostsForProfile(@PathVariable Long profileId) {
//        return postService.getAllPostsForProfile(profileId);
//    }

    @GetMapping("{username}")
    public Page<UserPostSummary> getAllPostsForUser(@PathVariable String username,
                                                    @RequestBody PaginationRequest pr) {
        return postService.getPostsByUsername(username, pr);
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
