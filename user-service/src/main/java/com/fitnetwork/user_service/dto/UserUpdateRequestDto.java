package com.fitnetwork.user_service.dto;

import com.fitnetwork.user_service.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateRequestDto {


        @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters") //Size is intended to be used for arrays, Strings, collections and maps. @Max(9000) as en example of numeric max
        @Pattern(regexp = "^[a-zA-Z_]+$", message = "Username can only contain letters, numbers and underscores")
        private String username;

        private LocalDate birthdayDate;
        private Double height;
        private Double weight;
        private User.Gender gender;
        private User.Level level;
        private String avatarUrl;
        private String statusMessage;
}
