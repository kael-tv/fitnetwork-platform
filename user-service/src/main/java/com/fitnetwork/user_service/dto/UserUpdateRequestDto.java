package com.fitnetwork.user_service.dto;

import com.fitnetwork.user_service.model.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateRequestDto {


        private String username;
        private LocalDate birthdayDate;
        private Double height;
        private Double weight;
        private User.Gender gender;
        private User.Level level;
        private String avatarUrl;
        private String statusMessage;
}
