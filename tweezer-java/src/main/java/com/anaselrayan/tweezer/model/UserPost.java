package com.anaselrayan.tweezer.model;

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
    private String postType;
    private String tags;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private UserProfile profile;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    public UserPost(String content, String postType, String tags, UserProfile profile) {
        this.content = content;
        this.postType = postType;
        this.tags = tags;
        this.profile = profile;
        this.createdAt = LocalDateTime.now();
    }
}
