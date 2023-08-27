package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.dao.UserPostDao;
import com.anaselrayan.tweezer.dto.UserPostDto;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserPostService {
    private final UserPostDao postDao;

    public PageableResponse<UserPostDto> getProfilePosts(Long profileId, PageRequest pr) {
        return postDao.selectProfilePosts(profileId, pr);
    }

    public void createUserPost(@NonNull UserPostDto post) {
        post.setCreatedAt(LocalDateTime.now());
        postDao.insertPost(post.getContent(), post.getPostType(),
                post.getCreatedAt(), post.getProfile().getProfileId());
    }

    public PageableResponse<UserPostDto> getFriendsPosts(Long profileId, PageRequest pr) {
        return postDao.selectFriendsPosts(profileId, pr);
    }
}
