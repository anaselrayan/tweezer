package com.anaselrayan.tweezer.model;

import com.anaselrayan.tweezer.security.models.Authority;
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
    private String username;
    private String email;
    private String password;
    private LocalDateTime joinedAt;

    @OneToOne
    private UserProfile profile;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "authority_id", nullable = false))
    private Set<Authority> authorities;

    public AppUser(String email, String password, UserProfile profile) {
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.joinedAt = LocalDateTime.now();
    }

}
