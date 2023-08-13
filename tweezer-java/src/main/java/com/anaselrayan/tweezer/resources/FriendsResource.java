package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.projection.UserProfileSummary;
import com.anaselrayan.tweezer.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/friends")
@RequiredArgsConstructor
public class FriendsResource {
    private final UserProfileService profileService;

    @GetMapping("{profileId}")
    public List<UserProfileSummary> getProfileFriends(@PathVariable Long profileId) {
        return profileService.getProfileFriends(profileId);
    }
}
