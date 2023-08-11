package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.UserProfile;
import com.anaselrayan.tweezer.projection.UserProfileDetailed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {

    Optional<UserProfileDetailed> findByUserId(Long userId);

    Optional<UserProfileDetailed> findByUserUsername(String username);
}
