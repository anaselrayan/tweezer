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
public class CommentDto implements RowMapper<CommentDto> {
    public String content;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public Long postId;
    public UserProfileSummary profile;

    @Override
    public CommentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CommentDto(
                rs.getString("content"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getTimestamp("updated_at").toLocalDateTime(),
                rs.getLong("post_id"),
                new UserProfileSummary().mapRow(rs, rowNum)
        );
    }
}
