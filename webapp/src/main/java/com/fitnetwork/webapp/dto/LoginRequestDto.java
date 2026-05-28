        package com.fitnetwork.webapp.dto;

        import lombok.Data;

        @Data
        public class LoginRequestDto {

                private String login; //Email or username
                private String password;
        }
