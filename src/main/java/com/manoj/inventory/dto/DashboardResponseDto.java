package com.manoj.inventory.dto;

import lombok.Data;

@Data
public class DashboardResponseDto {

    private Long totalProducts;
    private Long totalCategories;
    private Long totalSuppliers;
    private Long lowStockProducts;
}