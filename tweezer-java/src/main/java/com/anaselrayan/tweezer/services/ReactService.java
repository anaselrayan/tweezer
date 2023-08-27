package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.dao.ReactDao;
import com.anaselrayan.tweezer.dto.ReactDto;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReactService {
    private final ReactDao reactDao;

    public PageableResponse<ReactDto> getPostReacts(Long postId, PageRequest pr) {
        return reactDao.selectPostReacts(postId, pr);
    }

    public void addReact(ReactDto react) {
        react.createdAt = LocalDateTime.now();
        reactDao.insertReact(react);
    }

    public void deleteReact(Long postId, Long profileId) {
        reactDao.deleteReact(postId, profileId);
    }

    public void updateReact(ReactDto react) {
        reactDao.updateReact(react);
    }

    public PageableResponse<ReactDto> getPostReactsByType(Long postId, String type, PageRequest pr) {
        return reactDao.selectPostReactsByType(postId, type, pr);
    }

    public Optional<String> getUserReactOnPost(Long postId, Long profileId) {
        return reactDao.selectUserReactOnPost(postId, profileId);
    }
}
