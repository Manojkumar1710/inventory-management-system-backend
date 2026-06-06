package com.manoj.inventory.service;

import com.manoj.inventory.dto.CategoryRequestDto;
import com.manoj.inventory.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto dto);

    CategoryResponseDto getCategoryById(Long id);

    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto updateCategory(Long id,
                                       CategoryRequestDto dto);

    void deleteCategory(Long id);
}