package com.manoj.inventory.service.impl;

import com.manoj.inventory.dto.LoginRequestDto;
import com.manoj.inventory.dto.LoginResponseDto;
import com.manoj.inventory.entity.User;
import com.manoj.inventory.repository.UserRepository;
import com.manoj.inventory.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password"));

        boolean matches = passwordEncoder.matches(
                dto.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new RuntimeException(
                    "Invalid email or password");
        }

        return new LoginResponseDto(
                "Login Successful");
    }
}