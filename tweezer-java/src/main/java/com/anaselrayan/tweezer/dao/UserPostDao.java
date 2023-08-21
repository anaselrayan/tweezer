package com.anaselrayan.tweezer.dao;

import com.anaselrayan.tweezer.dto.UserPostDto;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserPostDao {
    private final JdbcTemplate jdbcTemplate;
    private final FeaturesDao featuresDao;

    public PageableResponse<UserPostDto> selectProfilePosts(Long profileId, PageRequest pr) {
        String sql = """
                    SELECT po.id AS post_id, po.content, po.tags, po.post_type, po.created_at,
                           pr.id AS profile_id, pr.firstname, pr.lastname, pr.profile_image
                    FROM posts po
                    JOIN profiles pr
                    ON po.profile_id = pr.id
                    WHERE po.profile_id = ?
                """;

        List<UserPostDto> content = jdbcTemplate.query(sql, new UserPostDto(), profileId);
        int tot = featuresDao.getRowsCount(sql, profileId);
        return new PageableResponse<>(content, tot, pr);
    }

    public void insertPost(String content, String postType, LocalDateTime createdAt, Long profileId) {
        String sql = """
                INSERT INTO posts(content, post_type, created_at, profile_id)
                VALUES (?, ?, ?, ?)
            """;
        jdbcTemplate.update(sql, content, postType, createdAt, profileId);
    }
}
