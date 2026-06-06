package com.manoj.inventory.service;

import com.manoj.inventory.dto.UserRequestDto;
import com.manoj.inventory.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUser(Long id,
                               UserRequestDto dto);

    void deleteUser(Long id);
}