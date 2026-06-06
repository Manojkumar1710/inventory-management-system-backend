package com.manoj.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestDto {

    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    private Double price;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotNull(message = "Category id is required")
    private Long categoryId;

    @NotNull(message = "Supplier id is required")
    private Long supplierId;
}