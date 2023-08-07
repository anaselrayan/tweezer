package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {
}
