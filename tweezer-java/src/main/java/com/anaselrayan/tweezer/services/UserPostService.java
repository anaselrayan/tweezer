package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.model.UserProfile;
import com.anaselrayan.tweezer.projection.UserPostSummary;
import com.anaselrayan.tweezer.repos.UserPostRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPostService {
    private final UserPostRepo postRepo;

    public Page<UserPostSummary> getAllPostsForProfile(Long profileId, Pageable pageable) {
        return postRepo.findAllByProfileId(profileId, pageable);
    }

    public UserPost getPostById(Long postId) {
        return postRepo.findById(postId).orElse(null);
    }


    public void createUserPost(@NonNull UserPost post) {
        post.setCreatedAt(LocalDateTime.now());
        postRepo.insertPost(post.getContent(), post.getPostType(),
                post.getCreatedAt(), post.getProfile().getId());
    }

    public void deleteUserPost(Long postId) {
        postRepo.deleteById(postId);
    }
}
