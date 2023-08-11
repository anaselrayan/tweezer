package com.anaselrayan.tweezer.security.providers;

import com.anaselrayan.tweezer.security.authentications.CredentialsAuthentication;
import com.anaselrayan.tweezer.security.models.Credentials;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CredentialsAuthenticationProvider implements AuthenticationProvider {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var auth = (CredentialsAuthentication) authentication;
        Credentials credentials = (Credentials) auth.getCredentials();
        var userDetails = userDetailsService.loadUserByUsername(credentials.username());
        if(passwordEncoder.matches(credentials.password(), userDetails.getPassword())) {
            System.out.println("good credentials.");
            return new CredentialsAuthentication(credentials, userDetails);
        }
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(CredentialsAuthentication.class);
    }
}
