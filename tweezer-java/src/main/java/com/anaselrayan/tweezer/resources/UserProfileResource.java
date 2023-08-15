package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.projection.UserProfileDetailed;
import com.anaselrayan.tweezer.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/profile")
public class UserProfileResource {
    private final UserProfileService profileService;

    @GetMapping("{username}")
    public UserProfileDetailed getUserProfile(@PathVariable String username) {
        return profileService.getProfileByUsername(username).orElse(null);
    }
}
