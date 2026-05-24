package com.fitnetwork.user_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class User {

        ///TODO annotations relations SQL

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String email;
        private String username;
        private String password;
        private LocalDate birthdayDate;
        private Double height;
        private Double weight;
        private Gender gender;
        private Level level;
        private String avatarUrl;
        private String statusMessage;
        private Boolean profileVisibility;
        private Role role;
        private Boolean isBanned;
        private LocalDateTime createdAt;

        //Nested classes"
        public enum Level {BEGINNER, INTERMEDIATE, ADVANCED}
        public enum Gender {Female, Male, Other}
        public enum Role{Admin, User}





}
