package com.manoj.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDto {

    @NotBlank(message = "Category name is required")
    private String name;

    private String description;
}