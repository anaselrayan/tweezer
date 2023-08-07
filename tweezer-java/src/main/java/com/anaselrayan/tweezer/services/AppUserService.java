package com.anaselrayan.tweezer.services;

import com.anaselrayan.tweezer.model.AppUser;
import com.anaselrayan.tweezer.repos.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepo userRepo;

    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }
}
