package com.fitnetwork.webapp.security;

import com.example.WebApp.client.UserClient;
import com.example.WebApp.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@FeignClient(name = "user-service", contextId = "userClient"))
public class CustomUserDetailsService implements UserDetailsService {

        private final UserClient userClient;
        ///TODO Import user

        public CustomUserDetailsService(UserClient userClient) {
                this.userClient = userClient;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userClient.findByUsername(username);
                if (user == null) {
                        throw new UsernameNotFoundException("User not found: " + username); ///TODO Import
                }
                return User.builder() ///TODO Import
                        .username(userDto.getUsername())
                        .password(userDto.getPassword())
                        .roles("USER")
                        .build();
        }
}
