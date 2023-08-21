package com.anaselrayan.tweezer.dao;

import com.anaselrayan.tweezer.dto.CommentDto;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentDao {
    private final JdbcTemplate jdbcTemplate;
    private final FeaturesDao featuresDao;

    public PageableResponse<CommentDto> selectPostComments(Long postId, PageRequest pageRequest) {
        String sql = """
                SELECT c.content, c.created_at, c.updated_at, c.post_id,
                       p.id AS profile_id, p.firstname, p.lastname, p.profile_image
                FROM comments c
                JOIN profiles p
                    on c.profile_id = p.id
                WHERE c.post_id = ?
                """;
        List<CommentDto> content = jdbcTemplate.query(sql, new CommentDto(), postId);
        int count = featuresDao.getRowsCount(sql, postId);
        return new PageableResponse<>(content, count, pageRequest);
    }


    public void insertComment(String content, LocalDateTime createdAt,
                       LocalDateTime updatedAt, Long postId, Long profileId) {
        String sql = """
                    INSERT INTO comments(content, created_at, updated_at, post_id, profile_id)
                            VALUES (?, ?, ?, ?, ?)
                """;
        jdbcTemplate.update(sql, content, createdAt, updatedAt, postId, profileId);
    }
}
