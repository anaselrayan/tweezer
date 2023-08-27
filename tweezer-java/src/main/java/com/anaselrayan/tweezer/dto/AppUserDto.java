package com.anaselrayan.tweezer.dto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto implements RowMapper<AppUserDto> {
    public Long userId;
    public String username;
    public Long profileId;
    public LocalDateTime joinedAt;

    @Override
    public AppUserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AppUserDto(
                rs.getLong("user_id"),
                rs.getString("username"),
                rs.getLong("profile_id"),
                rs.getTimestamp("joined_at").toLocalDateTime()
        );
    }
}
