package com.fitnetwork.user_service.security;

import com.example.WebApp.client.UserClient;
import com.example.WebApp.dto.UserDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

        private final UserClient userClient;

        public CustomUserDetailsService(UserClient userClient) {
                this.userClient = userClient;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserDto userDto = userClient.findByUsername(username); ///DTO TODO
                if (userDto == null) {
                        throw new UsernameNotFoundException("User not found: " + username); ///TODO Import
                }
                return User.builder() ///TODO Import
                        .username(userDto.getUsername())
                        .password(userDto.getPassword())
                        .roles("USER")
                        .build();
        }
}
