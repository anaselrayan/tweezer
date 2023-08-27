package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.model.AppUser;
import com.anaselrayan.tweezer.repos.AppUserRepo;
import com.anaselrayan.tweezer.security.models.UserSecretDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {
    private final AppUserRepo userRepo;

    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepo.findByEmail(email);
        if (user.isPresent())
            return new UserSecretDetails(user.get());

        throw new UsernameNotFoundException("Can't find this user!!");
    }
}
