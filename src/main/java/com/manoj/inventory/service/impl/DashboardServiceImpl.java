package com.manoj.inventory.service.impl;

import com.manoj.inventory.dto.DashboardResponseDto;
import com.manoj.inventory.repository.CategoryRepository;
import com.manoj.inventory.repository.ProductRepository;
import com.manoj.inventory.repository.SupplierRepository;
import com.manoj.inventory.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.manoj.inventory.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl
        implements DashboardService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;

    @Override
    public DashboardResponseDto getDashboard() {

        DashboardResponseDto dto =
                new DashboardResponseDto();

        dto.setTotalProducts(
                productRepository.count());

        dto.setTotalCategories(
                categoryRepository.count());

        dto.setTotalSuppliers(
                supplierRepository.count());
        dto.setTotalUsers(
                userRepository.count());

        dto.setLowStockProducts(
                (long) productRepository
                        .findByQuantityLessThan(5)
                        .size());

        return dto;
    }
}