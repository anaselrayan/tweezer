package com.anaselrayan.tweezer.model;

import com.anaselrayan.tweezer.enums.UserProfileType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "profiles")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String bio;
    private LocalDate birthdate;
    private String profileImage;
    private String coverImage;
    private UserProfileType profileType;
}
