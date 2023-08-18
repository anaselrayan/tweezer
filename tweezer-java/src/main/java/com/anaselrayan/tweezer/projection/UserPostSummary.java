package com.anaselrayan.tweezer.projection;
import java.time.LocalDateTime;

public interface UserPostSummary {
    Long getId();
    String getContent();
    String getPostType();
    LocalDateTime getCreatedAt();
    UserProfileSummary getProfile();
}
