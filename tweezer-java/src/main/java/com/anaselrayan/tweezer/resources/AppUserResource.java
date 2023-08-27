package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class AppUserResource {
    private final AppUserService userService;

}
