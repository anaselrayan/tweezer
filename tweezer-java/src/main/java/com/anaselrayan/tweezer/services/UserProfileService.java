package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.shared.PaginationRequest;
import com.anaselrayan.tweezer.projection.UserProfileDetailed;
import com.anaselrayan.tweezer.projection.UserProfileSummary;
import com.anaselrayan.tweezer.repos.UserProfileRepo;
import com.anaselrayan.tweezer.shared.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepo profileRepo;

    public Page<UserProfileSummary> getProfileFriends(Long profileId, PaginationRequest pr) {
        Pageable pageable = PaginationService.getPageable(pr);
        return profileRepo.findFriendsByProfile(profileId, pageable);
    }

    public Optional<UserProfileDetailed> getProfileByUsername(String username) {
        return profileRepo.findByUsername(username);
    }
}
