package com.manoj.inventory.controller;

import com.manoj.inventory.dto.SupplierRequestDto;
import com.manoj.inventory.dto.SupplierResponseDto;
import com.manoj.inventory.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "Supplier Management",
        description = "APIs for managing suppliers"
)
@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDto> createSupplier(
            @Valid @RequestBody SupplierRequestDto dto) {

        return ResponseEntity.ok(
                supplierService.createSupplier(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> getSupplierById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                supplierService.getSupplierById(id));
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponseDto>> getAllSuppliers() {

        return ResponseEntity.ok(
                supplierService.getAllSuppliers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> updateSupplier(
            @PathVariable Long id,
            @Valid @RequestBody SupplierRequestDto dto) {

        return ResponseEntity.ok(
                supplierService.updateSupplier(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(
            @PathVariable Long id) {

        supplierService.deleteSupplier(id);

        return ResponseEntity.ok(
                "Supplier deleted successfully");
    }
}