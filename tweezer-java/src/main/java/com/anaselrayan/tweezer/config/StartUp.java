package com.anaselrayan.tweezer.config;

import com.anaselrayan.tweezer.enums.UserPostType;
import com.anaselrayan.tweezer.model.AppUser;
import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.model.UserProfile;
import com.anaselrayan.tweezer.repos.AppUserRepo;
import com.anaselrayan.tweezer.repos.UserPostRepo;
import com.anaselrayan.tweezer.repos.UserProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {
    private final UserPostRepo postRepo;
    private final AppUserRepo userRepo;
    private final UserProfileRepo profileRepo;

    @Override
    public void run(String... args) throws Exception {
        UserProfile profile1 = new UserProfile();
        AppUser user1 = new AppUser("anas@gmail.com", "123", profile1);

        UserPost post1 = new UserPost("hello my name is Anas Elrayan",
                UserPostType.PUBLIC, "", user1);

        UserPost post2 = new UserPost("This is my second post!",
                UserPostType.FRIENDS, "", user1);

        profileRepo.save(profile1);
        userRepo.save(user1);
        postRepo.save(post1);
        postRepo.save(post2);
    }
}
