package com.anaselrayan.tweezer.projection;

import com.anaselrayan.tweezer.enums.UserPostType;
import java.time.LocalDateTime;

public interface UserPostSummary {
    Long getId();
    String getContent();
    UserPostType getPostType();
    LocalDateTime getCreatedAt();
    UserProfileSummary getProfile();
}
