package com.anaselrayan.tweezer.projection;

import com.anaselrayan.tweezer.enums.Gender;
import com.anaselrayan.tweezer.enums.UserProfileType;

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
    String getGender();
}
