package com.manoj.inventory.service;

import com.manoj.inventory.dto.LoginRequestDto;
import com.manoj.inventory.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto dto);
}