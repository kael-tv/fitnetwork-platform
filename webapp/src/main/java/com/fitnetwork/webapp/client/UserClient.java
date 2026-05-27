package com.example.WebApp.client;

import com.example.WebApp.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "patients", contextId = "userClient")
public interface UserClient {

        @PostMapping("/Users")
        UserDto addUser (@RequestBody UserDto userDto);

        @GetMapping("/Users/by-username/{username}")
        UserDto findByUserName(@PathVariable String username);

}
