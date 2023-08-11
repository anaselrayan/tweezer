package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.projection.UserPostSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPostRepo extends JpaRepository<UserPost, Long> {

    @Query(value = """
        select p.id as postId, p.content as content,
               p.postType as postType, p.createdAt as createdAt
        from UserPost p
        where p.profile.id = :profileId
    """)
    List<UserPostSummary> findPostsByProfileId(Long profileId);
}
