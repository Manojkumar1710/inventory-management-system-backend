package com.manoj.inventory;

import com.manoj.inventory.dto.ProductResponseDto;
import com.manoj.inventory.entity.Category;
import com.manoj.inventory.entity.Product;
import com.manoj.inventory.entity.Supplier;
import com.manoj.inventory.exception.ResourceNotFoundException;
import com.manoj.inventory.repository.CategoryRepository;
import com.manoj.inventory.repository.ProductRepository;
import com.manoj.inventory.repository.SupplierRepository;
import com.manoj.inventory.service.impl.ProductServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void shouldReturnProductWhenIdExists() {

        Category category = new Category();
        category.setName("Electronics");

        Supplier supplier = new Supplier();
        supplier.setName("Tech Wholesale");

        Product product = new Product();
        product.setId(1L);
        product.setName("HP Laptop");
        product.setDescription("Business Laptop");
        product.setPrice(55000.0);
        product.setQuantity(10);
        product.setCategory(category);
        product.setSupplier(supplier);

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        ProductResponseDto result =
                productService.getProductById(1L);

        assertNotNull(result);
        assertEquals("HP Laptop", result.getName());
        assertEquals(55000.0, result.getPrice());
        assertEquals("Electronics",
                result.getCategoryName());
    }

    @Test
    void shouldThrowExceptionWhenProductNotFound() {

        when(productRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> productService.getProductById(999L)
        );
    }
}