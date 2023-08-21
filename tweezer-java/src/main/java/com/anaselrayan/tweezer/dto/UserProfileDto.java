package com.anaselrayan.tweezer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDto implements RowMapper<UserProfileDto> {
    public Long profileId;
    public String firstname;
    public String lastname;
    public String profileImage;
    public String phone;
    public String bio;
    public String coverImage;
    public String profileType;
    public LocalDate birthdate;
    public String gender;

    @Override
    public UserProfileDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserProfileDto(
                rs.getLong("profile_id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("profile_image"),
                rs.getString("phone"),
                rs.getString("bio"),
                rs.getString("cover_image"),
                rs.getString("profile_type"),
                rs.getObject("birthdate", LocalDate.class),
                rs.getString("gender")
        );
    }
}
