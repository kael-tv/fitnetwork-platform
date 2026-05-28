package com.fitnetwork.webapp.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
        
        private String email;
        private String username;
        private String password;

        public void set() {
        }
}
