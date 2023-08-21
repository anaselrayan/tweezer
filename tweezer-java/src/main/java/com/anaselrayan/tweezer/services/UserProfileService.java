package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.dao.UserProfileDao;
import com.anaselrayan.tweezer.dto.UserProfileDto;
import com.anaselrayan.tweezer.dto.UserProfileSummary;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileDao profileDao;

    public PageableResponse<UserProfileSummary> getProfileFriends(Long profileId, PageRequest pr) {
        return profileDao.selectProfileFriends(profileId, pr);
    }

    public Optional<UserProfileDto> getProfileByUsername(String username) {
        return profileDao.selectByUsername(username);
    }
}
