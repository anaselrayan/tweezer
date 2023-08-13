package com.anaselrayan.tweezer.projection;

import java.time.LocalDateTime;

public interface CommentSummary {
    Long getId();
    String getContent();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    UserProfileSummary getProfile();
}
