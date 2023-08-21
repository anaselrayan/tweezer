package com.anaselrayan.tweezer.dao;

import com.anaselrayan.tweezer.dto.UserProfileDto;
import com.anaselrayan.tweezer.dto.UserProfileSummary;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserProfileDao {
    private final JdbcTemplate jdbcTemplate;
    private final FeaturesDao featuresDao;

    public Optional<UserProfileDto> selectByUsername(String username) {
        String sql = """
            SELECT p.id as profile_id, p.firstname, p.lastname,
                p.profile_image, p.phone, p.bio,
                p.cover_image, p.profile_type,
                p.birthdate, p.gender
            FROM profiles p
            join users u
            on u.profile_id = p.id
            where u.username = ?
        """;
        var res = jdbcTemplate.query(sql, new UserProfileDto(), username);
        if (!res.isEmpty())
            return Optional.of(res.get(0));
        return Optional.empty();
    }

    public PageableResponse<UserProfileSummary> selectProfileFriends(Long profileId, PageRequest pr) {
        String sql = """
                    SELECT p.id AS profile_id, p.firstname, p.lastname, p.profile_image
                    FROM profiles p
                    JOIN profiles_friends pf
                    ON pf.profile_id = p.id
                    WHERE pf.friend_id = ?
                """;
        var content = jdbcTemplate.query(sql, new UserProfileSummary(), profileId);
        int count = featuresDao.getRowsCount(sql, profileId);
        return new PageableResponse<>(content, count, pr);
    }

    public void insertFriend(Long profileId, Long friendId) {
        jdbcTemplate.update("INSERT INTO profiles_friends VALUES (?, ?), (?,?)",
                profileId, friendId, friendId, profileId);

    }
}

