package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.model.UserProfile;
import com.anaselrayan.tweezer.projection.UserProfileDetailed;
import com.anaselrayan.tweezer.repos.UserProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepo profileRepo;

    public List<UserProfile> getAllProfiles() {
        return profileRepo.findAll();
    }

    public UserProfileDetailed getUserProfile(Long userId) {
        return profileRepo.findByUserId(userId).orElse(null);
    }

    public UserProfileDetailed getUserProfile(String username) {
        return profileRepo.findByUserUsername(username).orElse(null);
    }
}
