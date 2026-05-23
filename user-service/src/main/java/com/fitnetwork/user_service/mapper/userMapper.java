package com.fitnetwork.user_service.mapper;

import com.fitnetwork.user_service.dto.UserProfileResponseDto;
import com.fitnetwork.user_service.dto.UserPublicResponseDto;
import com.fitnetwork.user_service.dto.UserUpdateRequestDto;
import com.fitnetwork.user_service.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class userMapper {

        public User toEntity(UserUpdateRequestDto dto) {
                User user = new User();
                user.setUsername(dto.getUsername());
                user.setBirthdayDate(dto.getBirthdayDate());
                user.setHeight(dto.getHeight());
                user.setWeight(dto.getWeight());
                user.setGender(dto.getGender());
                user.setLevel(dto.getLevel());
                user.setAvatarUrl(dto.getAvatarUrl());
                user.setStatusMessage(dto.getStatusMessage());
                return user;
        }

        public UserPublicResponseDto toPublicResponseDto (User user) {
                UserPublicResponseDto dto = new UserPublicResponseDto();
                dto.setUsername(user.getUsername());
                dto.setAgeComputed(calculateAge(user.getBirthdayDate()));
                dto.setLevel(user.getLevel());
                dto.setGender(user.getGender());
                dto.setAvatarUrl(user.getAvatarUrl());
                dto.setStatusMessage(user.getStatusMessage());
                dto.setCreatedAt(user.getCreatedAt());

                return dto;
        }

        public UserProfileResponseDto toProfileResponseDto (User user) {
                UserProfileResponseDto dto = new UserProfileResponseDto();
                        dto.setEmail(user.getEmail());
                        dto.setUsername(user.getUsername());
                        dto.setBirthdayDate(user.getBirthdayDate());
                        dto.setAgeComputed(calculateAge(user.getBirthdayDate()));
                        dto.setHeight(user.getHeight());
                        dto.setWeight(user.getWeight());
                        dto.setGender(user.getGender());
                        dto.setLevel(user.getLevel());
                        dto.setAvatarUrl(user.getAvatarUrl());
                        dto.setStatusMessage(user.getStatusMessage());
                        dto.setProfileVisibility(user.getProfileVisibility());
                        dto.setCreatedAt(user.getCreatedAt());

                        return dto;

        }

        private Integer calculateAge(LocalDate birthdayDate) {
                if (birthdayDate == null) return null;
                return Period.between(birthdayDate, LocalDate.now()).getYears();
        }
}
