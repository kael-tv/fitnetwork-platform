package com.fitnetwork.webapp.dto;

import lombok.Data;

@Data
public class AuthResponseDto {

        private String token;
        private String refreshToken; ///TODO
        private String username;
        private String role;
}
