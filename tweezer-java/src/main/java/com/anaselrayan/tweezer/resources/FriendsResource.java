package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.projection.UserProfileSummary;
import com.anaselrayan.tweezer.services.UserProfileService;
import com.anaselrayan.tweezer.shared.PaginationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/friends")
@RequiredArgsConstructor
public class FriendsResource {
    private final UserProfileService profileService;

    @GetMapping("{profileId}")
    public Page<UserProfileSummary> getProfileFriends(@PathVariable Long profileId,
                                                      @RequestBody PaginationRequest pr) {
        return profileService.getProfileFriends(profileId, pr);
    }
}
