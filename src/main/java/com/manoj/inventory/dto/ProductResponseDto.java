package com.manoj.inventory.dto;

import lombok.Data;

@Data
public class ProductResponseDto {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;

    private String categoryName;

    private String supplierName;
}