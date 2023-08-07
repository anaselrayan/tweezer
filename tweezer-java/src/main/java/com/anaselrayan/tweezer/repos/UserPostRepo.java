package com.anaselrayan.tweezer.repos;

import com.anaselrayan.tweezer.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostRepo extends JpaRepository<UserPost, Long> {

}
