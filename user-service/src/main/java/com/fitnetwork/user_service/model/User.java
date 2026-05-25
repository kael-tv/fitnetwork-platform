package com.fitnetwork.user_service.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "users")
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

        @Enumerated(EnumType.STRING)
        private Gender gender;

        @Enumerated(EnumType.STRING)
        private Level level;
        private String avatarUrl;
        private String statusMessage;
        private Boolean profileVisibility;

        @Enumerated(EnumType.STRING)
        private Role role;
        private boolean isBanned; //Because Boolean can be null
        private LocalDateTime createdAt;

        //Nested classes"
        public enum Level {BEGINNER, INTERMEDIATE, ADVANCED}
        public enum Gender {FEMALE, MALE, OTHER}
        public enum Role{ADMIN, USER}





}
