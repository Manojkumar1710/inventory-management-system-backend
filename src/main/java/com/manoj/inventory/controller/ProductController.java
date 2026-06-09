package com.manoj.inventory.controller;

import com.manoj.inventory.dto.ProductRequestDto;
import com.manoj.inventory.dto.ProductResponseDto;
import com.manoj.inventory.dto.StockRequestDto;
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

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDto>>
    searchProducts(
            @RequestParam String name) {

        return ResponseEntity.ok(
                productService.searchProducts(name));
    }

    @GetMapping("/sort")
    public ResponseEntity<List<ProductResponseDto>>
    getProductsSorted(
            @RequestParam String sortBy) {

        return ResponseEntity.ok(
                productService.getProductsSorted(sortBy));
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<ProductResponseDto>>
    getLowStockProducts() {

        return ResponseEntity.ok(
                productService.getLowStockProducts());
    }

    @PostMapping("/{id}/stock-in")
    public ResponseEntity<ProductResponseDto>
    stockInProduct(

            @PathVariable Long id,

            @RequestBody
            StockRequestDto dto) {

        return ResponseEntity.ok(
                productService.stockInProduct(
                        id,
                        dto.getQuantity()));
    }



    @PostMapping("/{id}/stock-out")
    public ResponseEntity<ProductResponseDto>
    stockOutProduct(

            @PathVariable Long id,

            @RequestBody
            StockRequestDto dto) {

        return ResponseEntity.ok(
                productService.stockOutProduct(
                        id,
                        dto.getQuantity()));
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