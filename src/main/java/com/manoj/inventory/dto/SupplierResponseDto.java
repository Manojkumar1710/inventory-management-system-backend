package com.manoj.inventory.dto;

import lombok.Data;

@Data
public class SupplierResponseDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;
}