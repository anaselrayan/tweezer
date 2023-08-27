package com.anaselrayan.tweezer.security.models;

import com.anaselrayan.tweezer.dto.AppUserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class AuthenticationResponse {
    private AppUserDto user;
    private boolean authenticated;
}
