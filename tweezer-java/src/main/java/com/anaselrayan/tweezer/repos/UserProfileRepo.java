package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.UserProfile;
import com.anaselrayan.tweezer.projection.UserProfileDetailed;
import com.anaselrayan.tweezer.projection.UserProfileSummary;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {

    @Query(value = """
        select p.id, p.firstname, p.lastname,
            p.profile_image, p.phone, p.bio,
            p.cover_image, p.profile_type, p.birthdate
        from profiles p
        join users u
        on u.profile_id = p.id
        where u.username = ?1
    """, nativeQuery = true)
    Optional<UserProfileDetailed> findByUsername(String username);

    @Query(value = """
        select p.id, p.firstname, p.lastname, p.profile_image
        from profiles p
        join profiles_friends pf
        on pf.profile_id = p.id
        where pf.friend_id = ?1
    """, nativeQuery = true)
    Page<UserProfileSummary> findFriendsByProfile(Long profileId, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = """
        insert into profiles_friends values (?1, ?2)
    """, nativeQuery = true)
    void addFriendToProfile(Long profileId, Long friendId);
}
