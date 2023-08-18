package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.projection.UserPostSummary;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface UserPostRepo extends JpaRepository<UserPost, Long> {

    Page<UserPostSummary> findAllByProfileId(Long profileId, Pageable pageable);

    @Query(value = """
        insert into posts(content, post_type, created_at, profile_id)
        values (?, ?, ?, ?)
    """, nativeQuery = true)
    @Modifying @Transactional
    void insertPost(String content, String postType, LocalDateTime createdAt, Long profileId);
}
