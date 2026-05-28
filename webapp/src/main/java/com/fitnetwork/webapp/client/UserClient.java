package com.fitnetwork.webapp.client;

import com.fitnetwork.webapp.dto.AuthResponseDto;
import com.fitnetwork.webapp.dto.RegisterRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", contextId = "userClient")
public interface UserClient {

        @PostMapping("/Users")
        AuthResponseDto addUser (@RequestBody RegisterRequestDto dto); //BDD ou DTO?

        @GetMapping("/Users/by-username/{username}")
        AuthResponseDto findByUsername(@PathVariable String username);

        @GetMapping("/users/by-email/{email}")
        AuthResponseDto findByEmail(@PathVariable String email);

}
