package com.anaselrayan.tweezer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDateTime joinedAt;

    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;

    @OneToOne
    @JsonIgnore
    private UserProfile profile;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<UserPost> posts;

    public AppUser(String email, String password, UserProfile profile) {
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.joinedAt = LocalDateTime.now();
    }
}
