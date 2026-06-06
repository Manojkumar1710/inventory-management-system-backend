package com.manoj.inventory.service.impl;

import com.manoj.inventory.dto.UserRequestDto;
import com.manoj.inventory.dto.UserResponseDto;
import com.manoj.inventory.entity.User;
import com.manoj.inventory.exception.ResourceNotFoundException;
import com.manoj.inventory.repository.UserRepository;
import com.manoj.inventory.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        User savedUser = userRepository.save(user);

        UserResponseDto responseDto = new UserResponseDto();

        responseDto.setId(savedUser.getId());
        responseDto.setUsername(savedUser.getUsername());
        responseDto.setEmail(savedUser.getEmail());
        responseDto.setRole(savedUser.getRole());

        return responseDto;
    }

    @Override
    public UserResponseDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        UserResponseDto responseDto = new UserResponseDto();

        responseDto.setId(user.getId());
        responseDto.setUsername(user.getUsername());
        responseDto.setEmail(user.getEmail());
        responseDto.setRole(user.getRole());

        return responseDto;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> {

                    UserResponseDto dto = new UserResponseDto();

                    dto.setId(user.getId());
                    dto.setUsername(user.getUsername());
                    dto.setEmail(user.getEmail());
                    dto.setRole(user.getRole());

                    return dto;

                }).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        User updatedUser = userRepository.save(user);

        UserResponseDto responseDto = new UserResponseDto();

        responseDto.setId(updatedUser.getId());
        responseDto.setUsername(updatedUser.getUsername());
        responseDto.setEmail(updatedUser.getEmail());
        responseDto.setRole(updatedUser.getRole());

        return responseDto;
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        userRepository.delete(user);
    }
}