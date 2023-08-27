package com.anaselrayan.tweezer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "reacts")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class React {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reactType;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private UserProfile profile;

}
