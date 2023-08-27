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
public class ReactDto implements RowMapper<ReactDto> {
    public Long reactId;
    public String reactType;
    public Long postId;
    public Long profileId;
    public LocalDateTime createdAt;
    public UserProfileSummary profile;

    public ReactDto(Long reactId, String reactType, LocalDateTime createdAt, UserProfileSummary profile) {
        this.reactId = reactId;
        this.reactType = reactType;
        this.createdAt = createdAt;
        this.profile = profile;
    }

    @Override
    public ReactDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ReactDto(
                rs.getLong("react_id"),
                rs.getString("react_type"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                new UserProfileSummary().mapRow(rs, rowNum)
        );
    }
}
