package com.anaselrayan.tweezer.security.filters;

import com.anaselrayan.tweezer.security.AppAuthenticationManager;
import com.anaselrayan.tweezer.security.authentications.CredentialsAuthentication;
import com.anaselrayan.tweezer.security.models.Credentials;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@RequiredArgsConstructor
public class CredentialsAuthenticationFilter extends OncePerRequestFilter {
    private final AuthenticationManager authManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String username = request.getHeader("email");
        String password = request.getHeader("password");
        if (null != username && null != password) {
            System.out.println(username + ":" + password);
            var authReq = new CredentialsAuthentication(new Credentials(username, password));
            var authResult = authManager.authenticate(authReq);
            if (authResult.isAuthenticated())
                SecurityContextHolder.getContext().setAuthentication(authResult);
            else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
