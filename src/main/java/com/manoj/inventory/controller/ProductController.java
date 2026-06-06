package com.manoj.inventory.controller;

import com.manoj.inventory.dto.ProductRequestDto;
import com.manoj.inventory.dto.ProductResponseDto;
import com.manoj.inventory.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product Management",
        description = "APIs for managing products"
)
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(
            @Valid @RequestBody ProductRequestDto dto) {

        return ResponseEntity.ok(
                productService.createProduct(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {

        return ResponseEntity.ok(
                productService.getAllProducts());
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<ProductResponseDto>>
    getProductsPaginated(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size) {

        return ResponseEntity.ok(
                productService.getProductsPaginated(
                        page,
                        size));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDto dto) {

        return ResponseEntity.ok(
                productService.updateProduct(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.ok(
                "Product deleted successfully");
    }
}