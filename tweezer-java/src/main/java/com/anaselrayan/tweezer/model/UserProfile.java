package com.anaselrayan.tweezer.model;

import com.anaselrayan.tweezer.enums.UserProfileType;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private UserProfileType profileType;

    @OneToOne(mappedBy = "profile")
    private AppUser user;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    private Set<UserPost> posts;

    @ManyToMany
    @JoinTable(
            name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    @JsonIgnore
    private Set<UserProfile> followers;
}
