package com.anaselrayan.tweezer.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FriendRequestDao {
    private final JdbcTemplate jdbcTemplate;

    public void addFriendRequest(Long profileId, Long senderId) {
        String sql = """
                    INSERT INTO friends_requests(profile_id, sender_id)
                    VALUES (?, ?)
                """;
        jdbcTemplate.update(sql, profileId, senderId);
    }

    public void removeFriendRequest(Long profileId, Long senderId) {
        jdbcTemplate.update("DELETE FROM friends_requests WHERE profile_id = ? AND sender_id = ?",
                profileId, senderId);
    }

    public void insertFriend(Long profileId, Long friendId) {
        removeFriendRequest(profileId, friendId);
        jdbcTemplate.update("INSERT INTO profiles_friends VALUES (?, ?), (?,?)",
                profileId, friendId, friendId, profileId);
    }
}
