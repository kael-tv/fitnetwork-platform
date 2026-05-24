package com.fitnetwork.user_service.service;

import com.fitnetwork.user_service.dto.UserProfileResponseDto;
import com.fitnetwork.user_service.dto.UserPublicResponseDto;
import com.fitnetwork.user_service.dto.UserUpdateRequestDto;
import com.fitnetwork.user_service.exception.ResourceNotFoundException;
import com.fitnetwork.user_service.mapper.userMapper;
import com.fitnetwork.user_service.model.User;
import com.fitnetwork.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


///TODO Finir CRUD, checker répartition avec auth ms, refactorer
@Service
public class UserService {


        //Bean Injection
        private final UserRepository userRepository;
        private final userMapper userMapper;


        public UserService(UserRepository userRepository, userMapper userMapper) {
                this.userRepository = userRepository;
                this.userMapper = userMapper;
        }

        //Read
        //Public
        public List<UserPublicResponseDto> getAllUsers(){//Public list for Users
                return userRepository.findAll()
                        .stream()
                        .map(userMapper::toPublicResponseDto)
                        .collect(Collectors.toList());
        }

        public UserPublicResponseDto getById(Long id) {
                User user = userRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
                return userMapper.toPublicResponseDto(user);
        }

        //Create







        //Admin and personal use only
        //Read
        public List<UserProfileResponseDto> getAllUsersAdmin() {
                return userRepository.findAll()
                        .stream()
                        .map(userMapper::toProfileResponseDto)
                        .collect(Collectors.toList());
        }

        //CREATE
        public UserProfileResponseDto addUser(UserUpdateRequestDto dto) {
                User user = userMapper.toEntity(dto);
                return userMapper.toProfileResponseDto(userRepository.save(user));
        }


        //UPDATE
        public UserProfileResponseDto updateUser(Long id, UserUpdateRequestDto dto) {
                User existing = userRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
                existing.setUsername(dto.getUsername());
                existing.setBirthdayDate(dto.getBirthdayDate());
                existing.setHeight(dto.getHeight());
                existing.setWeight(dto.getWeight());
                existing.setGender(dto.getGender());
                existing.setLevel(dto.getLevel());
                existing.setAvatarUrl(dto.getAvatarUrl());
                existing.setStatusMessage(dto.getStatusMessage()); ///TODO WIP

                return userMapper.toProfileResponseDto(userRepository.save(existing));
        }

        //DELETE
        public void deleteById(Long id) {
                userRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
        }










}
