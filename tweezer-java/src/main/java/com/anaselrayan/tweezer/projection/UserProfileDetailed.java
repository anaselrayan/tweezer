package com.anaselrayan.tweezer.projection;

import java.time.LocalDate;

public interface UserProfileDetailed {
    Long getId();
    String getFirstname();
    String getLastname();
    String getProfileImage();
    String getPhone();
    String getBio();
    String getCoverImage();
    String getProfileType();
    LocalDate getBirthdate();
}
