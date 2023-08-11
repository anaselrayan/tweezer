package com.anaselrayan.tweezer.security;

import com.anaselrayan.tweezer.security.authentications.CredentialsAuthentication;
import com.anaselrayan.tweezer.security.authentications.JwtAuthentication;
import com.anaselrayan.tweezer.security.providers.CredentialsAuthenticationProvider;
import com.anaselrayan.tweezer.security.providers.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

public class AppAuthenticationManager implements AuthenticationManager {
    private final List<AuthenticationProvider> providers = new ArrayList<>();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        for (AuthenticationProvider provider : providers) {
            if (provider.supports(authentication.getClass())) {
                return provider.authenticate(authentication);
            }
        }
        throw new ProviderNotFoundException("There is no supported authentication provider!");
    }

    public void addProvider(AuthenticationProvider provider) {
        this.providers.add(provider);
    }
}
