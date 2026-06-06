package com.manoj.inventory.dto;

import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;

    private String username;

    private String email;

    private String role;
}