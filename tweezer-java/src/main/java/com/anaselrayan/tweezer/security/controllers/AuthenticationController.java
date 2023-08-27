package com.anaselrayan.tweezer.security.controllers;

import com.anaselrayan.tweezer.security.models.AuthenticationResponse;
import com.anaselrayan.tweezer.security.models.LoginRequest;
import com.anaselrayan.tweezer.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;

    @PostMapping("/login")
    public AuthenticationResponse getLogin(@RequestBody LoginRequest request) {
        return this.authService.authenticate(request);
    }
}
