package com.fitnetwork.webapp.controller;

import com.fitnetwork.webapp.client.UserClient;

import com.fitnetwork.webapp.dto.RegisterRequestDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

        private final UserClient userClient;
        private final PasswordEncoder passwordEncoder;

        public WebController(UserClient userClient, PasswordEncoder passwordEncoder) {
                this.userClient = userClient;
                this.passwordEncoder = passwordEncoder;
        }

        @GetMapping("/signup")
        public String showSignup(Model model) { //Prepare an object and show signup
                     model.addAttribute("user", new RegisterRequestDto());
                return "signup"; //Look for src/main/resources/templates.signup.html
        }

        @PostMapping("/signup")
        public String processSignup(@ModelAttribute RegisterRequestDto requestDto) {

                RegisterRequestDto registerDto = new RegisterRequestDto();
                registerDto.setEmail(requestDto.getEmail());
                registerDto.setUsername(requestDto.getUsername());
                registerDto.setPassword(
                        passwordEncoder.encode(requestDto.getPassword()));

                userClient.addUser(registerDto);
                return "redirect:/login";
        }

        @GetMapping("/login")
        public String showLogin() {
                return "login";
        }

        @GetMapping("/home")
        public String showHome() {
                return "home";
        }

        @GetMapping("/logout")
        public String logout(HttpSession session) {

                session.invalidate();

                return "redirect:/login";
        }
}
