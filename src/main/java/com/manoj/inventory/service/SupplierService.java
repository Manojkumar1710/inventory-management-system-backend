package com.manoj.inventory.service;

import com.manoj.inventory.dto.SupplierRequestDto;
import com.manoj.inventory.dto.SupplierResponseDto;

import java.util.List;

public interface SupplierService {

    SupplierResponseDto createSupplier(SupplierRequestDto dto);

    SupplierResponseDto getSupplierById(Long id);

    List<SupplierResponseDto> getAllSuppliers();

    SupplierResponseDto updateSupplier(Long id,
                                       SupplierRequestDto dto);

    void deleteSupplier(Long id);
}