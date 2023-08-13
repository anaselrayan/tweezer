package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.projection.UserPostSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPostRepo extends JpaRepository<UserPost, Long> {

    List<UserPostSummary> findAllByProfileId(Long profileId);

}
