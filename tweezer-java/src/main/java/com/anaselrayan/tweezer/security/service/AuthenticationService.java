package com.anaselrayan.tweezer.security.service;

import com.anaselrayan.tweezer.dao.AppUserDao;
import com.anaselrayan.tweezer.security.authentications.CredentialsAuthentication;
import com.anaselrayan.tweezer.security.models.AuthenticationResponse;
import com.anaselrayan.tweezer.security.models.Credentials;
import com.anaselrayan.tweezer.security.models.LoginRequest;
import com.anaselrayan.tweezer.security.providers.CredentialsAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CredentialsAuthenticationProvider authProvider;
    private final AppUserDao userDao;

    public AuthenticationResponse authenticate(LoginRequest req) {
        var authReq = new CredentialsAuthentication(
                new Credentials(req.email(), req.password())
        );
        var authResult = authProvider.authenticate(authReq);
        if (authResult.isAuthenticated()) {
            var user = userDao.selectUserDetails(req.email());
            return new AuthenticationResponse(user.get(), true);
        }
        return new AuthenticationResponse(null, false);
    }

    public AuthenticationResponse authenticate() {
        return null;
    }
}
