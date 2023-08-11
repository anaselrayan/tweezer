package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.AppUser;
import com.anaselrayan.tweezer.projection.UserSecretsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    @Query(value = """
        SELECT id, email, password FROM users WHERE email = :email
    """, nativeQuery = true)
    Optional<UserSecretsProjection> findByEmail(String email);


}
