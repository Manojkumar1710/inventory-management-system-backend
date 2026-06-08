package com.manoj.inventory.dto;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}