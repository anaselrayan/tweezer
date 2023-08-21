package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.dto.UserProfileSummary;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import com.anaselrayan.tweezer.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/friends")
@RequiredArgsConstructor
public class FriendsResource {
    private final UserProfileService profileService;

    @GetMapping("{profileId}")
    public PageableResponse<UserProfileSummary> getProfileFriends(@PathVariable Long profileId,
                                                                  @RequestParam Integer page,
                                                                  @RequestParam(required = false) Integer size) {
        var pr = new PageRequest(page, size);
        return profileService.getProfileFriends(profileId, pr);
    }
}
