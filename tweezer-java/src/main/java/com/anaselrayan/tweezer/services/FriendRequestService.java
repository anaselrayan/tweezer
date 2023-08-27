package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.dao.FriendRequestDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendRequestService {
    private final FriendRequestDao friendRequestDao;

    public void addFriendRequestForProfile(Long profileId, Long senderId) {
        friendRequestDao.addFriendRequest(profileId, senderId);
    }

    public void removeFriendRequestForProfile(Long profileId, Long senderId) {
        friendRequestDao.removeFriendRequest(profileId, senderId);
    }

    public void addFriendToProfile(Long profileId, Long friendId) {
        friendRequestDao.insertFriend(profileId, friendId);
    }
}
