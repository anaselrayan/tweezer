package com.anaselrayan.tweezer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDto implements RowMapper<UserPostDto> {
    public Long postId;
    public String content;
    public String tags;
    public String postType;
    public Long reacts;
    public LocalDateTime createdAt;
    public UserProfileSummary profile;

    @Override
    public UserPostDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserPostDto(
                rs.getLong("post_id"),
                rs.getString("content"),
                rs.getString("tags"),
                rs.getString("post_type"),
                rs.getLong("reacts"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                new UserProfileSummary().mapRow(rs, rowNum)
        );
    }
}
