package com.anaselrayan.tweezer.security.config;

import com.anaselrayan.tweezer.repos.AppUserRepo;
import com.anaselrayan.tweezer.security.AppAuthenticationManager;
import com.anaselrayan.tweezer.services.AppUserService;
import com.anaselrayan.tweezer.security.filters.CredentialsAuthenticationFilter;
import com.anaselrayan.tweezer.security.providers.CredentialsAuthenticationProvider;
import com.anaselrayan.tweezer.security.providers.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final AppUserRepo userRepo;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(c-> {
            c.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(c-> {
           c.anyRequest().permitAll();
        });

        http.addFilterBefore(
                new CredentialsAuthenticationFilter(authenticationManager()),
                UsernamePasswordAuthenticationFilter.class
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new AppUserService(userRepo);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager() {
        var manager = new AppAuthenticationManager();
        manager.addProvider(new CredentialsAuthenticationProvider(passwordEncoder(),
                userDetailsService()));
        manager.addProvider(new JwtAuthenticationProvider());
        return manager;
    }
}
