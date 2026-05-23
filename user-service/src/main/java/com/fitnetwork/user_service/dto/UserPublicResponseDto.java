package com.fitnetwork.user_service.dto;

import com.fitnetwork.user_service.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserPublicResponseDto {
        private String username;
        private Integer ageComputed;
        private User.Level level;
        private User.Gender gender;
        private String avatarUrl;
        private String statusMessage;
        private LocalDateTime createdAt;
}
