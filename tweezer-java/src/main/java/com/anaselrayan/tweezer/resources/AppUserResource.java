package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.dto.UserDTO;
import com.anaselrayan.tweezer.model.AppUser;
import com.anaselrayan.tweezer.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class AppUserResource {
    private final AppUserService userService;

    @GetMapping("all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
}
