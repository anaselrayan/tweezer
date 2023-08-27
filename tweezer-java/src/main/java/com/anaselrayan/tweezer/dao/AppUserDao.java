package com.anaselrayan.tweezer.dao;

import com.anaselrayan.tweezer.dto.AppUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AppUserDao {
    private final JdbcTemplate jdbcTemplate;

    public Optional<AppUserDto> selectUserDetails(String email) {
        String sql = """
                    SELECT u.id as user_id, u.username, u.profile_id, u.joined_at
                    FROM users u 
                    WHERE u.email = ?
                """;
        var res = jdbcTemplate.query(sql, new AppUserDto(), email);
        if (!res.isEmpty())
            return Optional.of(res.get(0));
        return Optional.empty();
    }
}
