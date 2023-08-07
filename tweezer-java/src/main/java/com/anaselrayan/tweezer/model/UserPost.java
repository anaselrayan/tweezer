package com.anaselrayan.tweezer.model;

import com.anaselrayan.tweezer.enums.UserPostType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "posts")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPost {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private UserPostType postType;
    private String tags;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    public UserPost(String content, UserPostType postType, String tags, AppUser user) {
        this.content = content;
        this.postType = postType;
        this.tags = tags;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }
}
