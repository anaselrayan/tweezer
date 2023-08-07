package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.model.UserProfile;
import com.anaselrayan.tweezer.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("profiles")
public class UserProfileResource {
    private final UserProfileService profileService;

    @GetMapping("all")
    public List<UserProfile> getAllProfiles() {
        return profileService.getAllProfiles();
    }
}
