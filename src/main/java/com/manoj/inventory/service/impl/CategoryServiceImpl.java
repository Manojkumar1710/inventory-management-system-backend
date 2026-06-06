package com.manoj.inventory.service.impl;

import com.manoj.inventory.dto.CategoryRequestDto;
import com.manoj.inventory.dto.CategoryResponseDto;
import com.manoj.inventory.entity.Category;
import com.manoj.inventory.exception.ResourceNotFoundException;
import com.manoj.inventory.repository.CategoryRepository;
import com.manoj.inventory.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto dto) {

        Category category = new Category();

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        Category savedCategory = categoryRepository.save(category);

        CategoryResponseDto responseDto = new CategoryResponseDto();

        responseDto.setId(savedCategory.getId());
        responseDto.setName(savedCategory.getName());
        responseDto.setDescription(savedCategory.getDescription());

        return responseDto;
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        CategoryResponseDto responseDto = new CategoryResponseDto();

        responseDto.setId(category.getId());
        responseDto.setName(category.getName());
        responseDto.setDescription(category.getDescription());

        return responseDto;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(category -> {

                    CategoryResponseDto dto = new CategoryResponseDto();

                    dto.setId(category.getId());
                    dto.setName(category.getName());
                    dto.setDescription(category.getDescription());

                    return dto;

                }).collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto updateCategory(Long id,
                                              CategoryRequestDto dto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        Category updatedCategory = categoryRepository.save(category);

        CategoryResponseDto responseDto = new CategoryResponseDto();

        responseDto.setId(updatedCategory.getId());
        responseDto.setName(updatedCategory.getName());
        responseDto.setDescription(updatedCategory.getDescription());

        return responseDto;
    }

    @Override
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        categoryRepository.delete(category);
    }
}