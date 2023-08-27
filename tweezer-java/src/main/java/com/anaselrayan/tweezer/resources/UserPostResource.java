package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.dto.UserPostDto;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import com.anaselrayan.tweezer.services.UserPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user-posts")
public class UserPostResource {
    private final UserPostService postService;

    @GetMapping("{profileId}")
    public PageableResponse<UserPostDto> getAllPostsForProfile(@PathVariable Long profileId,
                                                               @RequestParam Integer page,
                                                               @RequestParam(required = false) Integer size) {
        var pr = new PageRequest(page, size);
        return postService.getProfilePosts(profileId, pr);
    }

    @GetMapping("public/{profileId}")
    public PageableResponse<UserPostDto> getFriendsPosts(@PathVariable Long profileId,
                                                         @RequestParam Integer page,
                                                         @RequestParam(required = false) Integer size,
                                                         @RequestParam(required = false) Boolean asc,
                                                         @RequestParam(required = false) String sortCol) {
        var pr = new PageRequest(page, size, asc, sortCol);
        return postService.getFriendsPosts(profileId, pr);
    }

    @PostMapping
    public void addPost(@RequestBody UserPostDto post) {
        postService.createUserPost(post);
    }
}
