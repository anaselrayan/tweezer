package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.projection.UserProfileSummary;
import com.anaselrayan.tweezer.services.PaginationService;
import com.anaselrayan.tweezer.services.UserProfileService;
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
                                                      @RequestParam Integer page,
                                                      @RequestParam(required = false) Integer size) {
        return profileService.getProfileFriends(profileId, PaginationService.getPageable(page, size));
    }
}
