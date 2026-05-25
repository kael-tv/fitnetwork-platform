package com.fitnetwork.user_service.controller;


import com.fitnetwork.user_service.dto.UserProfileResponseDto;
import com.fitnetwork.user_service.dto.UserPublicResponseDto;
import com.fitnetwork.user_service.dto.UserUpdateRequestDto;
import com.fitnetwork.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @GetMapping
        public ResponseEntity<List<UserPublicResponseDto>> getAllPublicUsers() {
                return ResponseEntity.ok(userService.getAllUsers());

        }

        @GetMapping("/{id}")
        public ResponseEntity<UserPublicResponseDto> getPublicById (@PathVariable Long id) {
                return ResponseEntity.ok(userService.getById(id));
        }

        //Admin
        @GetMapping("/admin")
        public ResponseEntity<List<UserProfileResponseDto>> getAllUsers() {
                return ResponseEntity.ok(userService.getAllUsersAdmin());

        }

        @GetMapping("/admin/{id}")
        public ResponseEntity<UserProfileResponseDto> getProfileById (@PathVariable Long id) {
                return ResponseEntity.ok(userService.getProfileById(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<UserProfileResponseDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateRequestDto dto) {
                return ResponseEntity.ok(userService.updateUser(id, dto));
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
                userService.deleteById(id);
                return ResponseEntity.noContent().build();
        }




}
