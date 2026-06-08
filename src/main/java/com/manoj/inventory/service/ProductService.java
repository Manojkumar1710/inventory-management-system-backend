package com.manoj.inventory.service;

import com.manoj.inventory.dto.ProductRequestDto;
import com.manoj.inventory.dto.ProductResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto dto);

    ProductResponseDto getProductById(Long id);

    List<ProductResponseDto> getAllProducts();

    Page<ProductResponseDto> getProductsPaginated(
            int page,
            int size
    );

    List<ProductResponseDto> searchProducts(String name);

    List<ProductResponseDto> getProductsSorted(String sortBy);

    ProductResponseDto updateProduct(Long id,
                                     ProductRequestDto dto);

    void deleteProduct(Long id);
}