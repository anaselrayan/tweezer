package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.projection.UserPostSummary;
import com.anaselrayan.tweezer.repos.UserPostRepo;
import com.anaselrayan.tweezer.shared.PaginationRequest;
import com.anaselrayan.tweezer.shared.PaginationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPostService {
    private final UserPostRepo postRepo;

    public List<UserPostSummary> getAllPostsForProfile(Long profileId) {
        return postRepo.findAllByProfileId(profileId);
    }

    public Page<UserPostSummary> getPostsByUsername(String username, PaginationRequest pr) {
        Pageable pageable = PaginationService.getPageable(pr);
        return postRepo.findAllByUsername(username, pageable);
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
