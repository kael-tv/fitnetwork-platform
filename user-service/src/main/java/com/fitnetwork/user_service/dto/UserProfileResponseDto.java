package com.fitnetwork.user_service.dto;

import com.fitnetwork.user_service.model.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserProfileResponseDto {

        private String email;
        private String username;
        private LocalDate birthdayDate;
        private Integer ageComputed;
        private Double height;
        private Double weight;
        private User.Gender gender;
        private User.Level level;
        private String avatarUrl;
        private String statusMessage;
        private Boolean profileVisibility;
        private User.Role role;
        private LocalDateTime createdAt;



}
