package com.anaselrayan.tweezer.security.authentications;

import com.anaselrayan.tweezer.security.models.Credentials;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CredentialsAuthentication implements Authentication {
    private final Credentials credentials;
    private final UserDetails userDetails;
    private boolean authenticated;

    public CredentialsAuthentication(Credentials credentials) {
        this.credentials = credentials;
        this.authenticated = false;
        this.userDetails = null;
    }

    public CredentialsAuthentication(Credentials credentials, UserDetails userDetails) {
        this.credentials = credentials;
        this.userDetails = userDetails;
        this.authenticated = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (null != userDetails)
            return userDetails.getAuthorities();
        return List.of();
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userDetails.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return CredentialsAuthentication.class.getName();
    }
}
