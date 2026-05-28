package com.fitnetwork.webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


        private final CustomUserDetailsService customUserDetailsService;

        public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
                this.customUserDetailsService = customUserDetailsService;
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                        .userDetailsService(customUserDetailsService)
                        .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/signup", "/login").permitAll() //PermitAll: can be accessed even logged out
                                .anyRequest().authenticated() //Need to be logged
                        )
                        .formLogin(form -> form
                                .loginPage("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                        )
                        .logout(logout -> logout.permitAll());

                return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}
