package com.anaselrayan.tweezer.config;

import com.anaselrayan.tweezer.dao.ReactDao;
import com.anaselrayan.tweezer.dao.UserProfileDao;
import com.anaselrayan.tweezer.enums.Gender;
import com.anaselrayan.tweezer.enums.UserPostType;
import com.anaselrayan.tweezer.enums.UserProfileType;
import com.anaselrayan.tweezer.model.AppUser;
import com.anaselrayan.tweezer.model.Comment;
import com.anaselrayan.tweezer.model.Post;
import com.anaselrayan.tweezer.model.UserProfile;
import com.anaselrayan.tweezer.repos.AppUserRepo;
import com.anaselrayan.tweezer.repos.CommentRepo;
import com.anaselrayan.tweezer.repos.UserPostRepo;
import com.anaselrayan.tweezer.repos.UserProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {
    private final UserPostRepo postRepo;
    private final AppUserRepo userRepo;
    private final UserProfileRepo profileRepo;
    private final UserProfileDao profileDao;
    private final PasswordEncoder passwordEncoder;
    private final CommentRepo commentRepo;
    private final ReactDao reactDao;

    @Override
    public void run(String... args) throws Exception {
        UserProfile profile1 = new UserProfile("Anas", "Elrayan",
                "0107263786",
                "Hi my name is anas elrayan, I am new to tweezer. but I am happy to be here in this community",
                LocalDate.of(1999, 9, 20), "assets/images./1.jpg",
                "assets/images/bg.jpg", UserProfileType.PRIVATE.name(), Gender.MALE.name());
        UserProfile profile2 = new UserProfile();
        UserProfile profile3 = new UserProfile();
        profile1.setFirstname("Anas");
        profile2.setFirstname("Ahmed");
        profile3.setFirstname("Belal");

        AppUser user1 =
                new AppUser("anas_elrayan", "an", passwordEncoder.encode(""), profile1);
        AppUser user2 =
                new AppUser("ahmed", "ah", passwordEncoder.encode(""), profile2);
        AppUser user3 =
                new AppUser("belal", "bl", passwordEncoder.encode(""), profile3);

        Post post1 = new Post("Anas First Post",
                UserPostType.PUBLIC.name(), "", profile1);

        Post post2 = new Post("Anas second post!",
                UserPostType.FRIENDS.name(), "", profile1);

        Post post3 = new Post("Belal First Post",
                UserPostType.FRIENDS.name(), "", profile3);

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

        profileDao.insertFriend(profile1.getId(), profile3.getId());
        profileDao.insertFriend(profile1.getId(), profile2.getId());
    }
}
