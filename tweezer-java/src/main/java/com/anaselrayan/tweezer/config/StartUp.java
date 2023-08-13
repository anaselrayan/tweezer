package com.anaselrayan.tweezer.config;

import com.anaselrayan.tweezer.enums.UserPostType;
import com.anaselrayan.tweezer.model.AppUser;
import com.anaselrayan.tweezer.model.Comment;
import com.anaselrayan.tweezer.model.UserPost;
import com.anaselrayan.tweezer.model.UserProfile;
import com.anaselrayan.tweezer.repos.AppUserRepo;
import com.anaselrayan.tweezer.repos.CommentRepo;
import com.anaselrayan.tweezer.repos.UserPostRepo;
import com.anaselrayan.tweezer.repos.UserProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {
    private final UserPostRepo postRepo;
    private final AppUserRepo userRepo;
    private final UserProfileRepo profileRepo;
    private final PasswordEncoder passwordEncoder;
    private final CommentRepo commentRepo;

    @Override
    public void run(String... args) throws Exception {
        UserProfile profile1 = new UserProfile();
        UserProfile profile2 = new UserProfile();
        UserProfile profile3 = new UserProfile();
        profile1.setFirstname("Anas");
        profile2.setFirstname("Ahmed");
        profile3.setFirstname("Belal");

        AppUser user1 =
                new AppUser("anas_elrayan", "anas@gmail.com", passwordEncoder.encode("123"), profile1);
        AppUser user2 =
                new AppUser("ahmed", "ahmed@gmail.com", passwordEncoder.encode("123"), profile2);
        AppUser user3 =
                new AppUser("belal","belal@gmail.com", passwordEncoder.encode("123"), profile3);

        UserPost post1 = new UserPost("Anas First Post",
                UserPostType.PUBLIC, "", profile1);

        UserPost post2 = new UserPost("Anas second post!",
                UserPostType.FRIENDS, "", profile1);

        UserPost post3 = new UserPost("Belal First Post",
                UserPostType.FRIENDS, "", profile3);

        Comment comment1 = new Comment("Belal On Anas's 1st post", post1, profile3);
        Comment comment2 = new Comment("Belal On Anas's 2nd post", post2, profile3);
        Comment comment3 = new Comment("Anas On Belal's 1st post", post3, profile1);

        profileRepo.save(profile1);
        profileRepo.save(profile2);
        profileRepo.save(profile3);

        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);

        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);

        commentRepo.save(comment1);
        commentRepo.save(comment2);
        commentRepo.save(comment3);

        profileRepo.addFriendToProfile(profile1.getId(), profile3.getId());
        profileRepo.addFriendToProfile(profile1.getId(), profile2.getId());
    }
}
