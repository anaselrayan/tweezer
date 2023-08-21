package com.anaselrayan.tweezer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileSummary implements RowMapper<UserProfileSummary> {
    public Long profileId;
    public String firstname;
    public String lastname;
    public String profileImage;

    @Override
    public UserProfileSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserProfileSummary(
                rs.getLong("profile_id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("profile_image")
        );
    }
}
