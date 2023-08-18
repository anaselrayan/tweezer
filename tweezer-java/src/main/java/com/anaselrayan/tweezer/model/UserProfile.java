package com.anaselrayan.tweezer.model;

import com.anaselrayan.tweezer.enums.Gender;
import com.anaselrayan.tweezer.enums.UserProfileType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "profiles")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String phone;
    private String bio;
    private LocalDate birthdate;
    private String profileImage;
    private String coverImage;
    private String profileType;
    private String gender;

    @OneToMany(mappedBy = "profile")
    private Set<UserPost> posts;

    @ManyToMany
    @JoinTable(
            name = "profiles_friends",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private Set<UserProfile> friends;

    public UserProfile(String firstname, String lastname, String phone, String bio, LocalDate birthdate, String profileImage, String coverImage, String profileType, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.bio = bio;
        this.birthdate = birthdate;
        this.profileImage = profileImage;
        this.coverImage = coverImage;
        this.profileType = profileType;
        this.gender = gender;
    }

    public UserProfile(Long id) {
        this.id = id;
    }
}
