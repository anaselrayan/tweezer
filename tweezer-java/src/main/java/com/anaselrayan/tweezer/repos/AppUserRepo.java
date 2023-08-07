package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
}
