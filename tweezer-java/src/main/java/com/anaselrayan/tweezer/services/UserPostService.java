package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.repos.UserPostRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPostService {
    private final UserPostRepo postRepo;

    public List<UserPost> getAllPosts() {
        return postRepo.findAll();
    }

    public UserPost getPostById(Long postId) {
        return postRepo.findById(postId).orElse(null);
    }

    public UserPost addUserPost(@NonNull UserPost post) {
        post.setCreatedAt(LocalDateTime.now());
        return postRepo.save(post);
    }

    public void deleteUserPost(Long postId) {
        postRepo.deleteById(postId);
    }
}
