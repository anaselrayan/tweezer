package com.anaselrayan.tweezer.dao;

import com.anaselrayan.tweezer.dto.ReactDto;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import com.anaselrayan.tweezer.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReactDao {
    private final JdbcTemplate jdbcTemplate;

    public PageableResponse<ReactDto> selectPostReacts(Long postId, PageRequest pr) {
        String sql = """
                    SELECT r.id as react_id, r.react_type, r.created_at,
                        p.id as profile_id, p.firstname, p.lastname, p.profile_image
                    FROM reacts r
                    JOIN profiles p
                        ON  r.profile_id = p.id
                    WHERE r.post_id = ?
                """;
        sql = PaginationService.addSortAndPaginationQuery(sql, pr);
        var content = jdbcTemplate.query(sql, new ReactDto(),postId);
        return new PageableResponse<>(content, 0, pr);
    }

    public PageableResponse<ReactDto> selectPostReactsByType(Long postId, String type, PageRequest pr) {
        String sql = """
                    SELECT r.id as react_id, r.react_type, r.created_at,
                        p.id as profile_id, p.firstname, p.lastname, p.profile_image
                    FROM reacts r
                    JOIN profiles p
                        ON  r.profile_id = p.id
                    WHERE r.post_id = ? AND react_type = ?
                """;
        sql = PaginationService.addSortAndPaginationQuery(sql, pr);
        var content = jdbcTemplate.query(sql, new ReactDto(),postId, type);
        return new PageableResponse<>(content, 0, pr);
    }

    public void insertReact(ReactDto react) {
        String sql = """
                INSERT INTO reacts(react_type, post_id, profile_id, created_at)
                VALUES(?, ?, ?, ?)
                """;
        jdbcTemplate.update(sql, react.reactType, react.postId, react.profileId, react.createdAt);
        jdbcTemplate.update("UPDATE posts SET reacts = reacts+1 WHERE id = ?", react.postId);
    }

    public void deleteReact(Long postId, Long profileId) {
        jdbcTemplate.update("DELETE FROM reacts WHERE post_id = ? AND profile_id = ?", postId, profileId);
        jdbcTemplate.update("UPDATE posts SET reacts = reacts-1 WHERE id = ?", postId);
    }

    public void updateReact(ReactDto react) {
        jdbcTemplate.update("UPDATE reacts SET react_type = ? WHERE post_id = ? AND profile_id = ?",
                react.reactType, react.postId, react.profileId);
    }

    public Optional<String> selectUserReactOnPost(Long postId, Long profileId) {
        String sql = """
                SELECT r.react_type
                FROM reacts r
                JOIN profiles p
                    ON  r.profile_id = p.id
                WHERE r.post_id = ? AND r.profile_id = ?
                """;
        var res = jdbcTemplate.queryForList(sql, String.class, postId, profileId);
       if (res.isEmpty())
           return Optional.empty();
       return Optional.of(res.get(0));
    }
}
