package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.projection.UserPostSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPostRepo extends JpaRepository<UserPost, Long> {

    List<UserPostSummary> findAllByProfileId(Long profileId);

    @Query(value = """
    select  po.id, po.content, po.post_type,
            po.created_at, pr.id, pr.bio,
            pr.birthdate, pr.cover_image, pr.firstname,
            pr.lastname, pr.phone, pr.profile_image,
            pr.profile_type
    from posts po
    join profiles pr
    on pr.id = po.profile_id
    join users u
    on pr.id = u.profile_id
    where u.username = ?1
    """, nativeQuery = true)
    Page<UserPostSummary> findAllByUsername(String username, Pageable pageable);

}
