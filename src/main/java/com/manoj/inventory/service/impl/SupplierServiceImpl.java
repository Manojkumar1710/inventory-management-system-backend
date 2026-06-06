package com.manoj.inventory.service.impl;

import com.manoj.inventory.dto.SupplierRequestDto;
import com.manoj.inventory.dto.SupplierResponseDto;
import com.manoj.inventory.entity.Supplier;
import com.manoj.inventory.exception.ResourceNotFoundException;
import com.manoj.inventory.repository.SupplierRepository;
import com.manoj.inventory.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierResponseDto createSupplier(SupplierRequestDto dto) {

        Supplier supplier = new Supplier();

        supplier.setName(dto.getName());
        supplier.setEmail(dto.getEmail());
        supplier.setPhone(dto.getPhone());
        supplier.setAddress(dto.getAddress());

        Supplier savedSupplier = supplierRepository.save(supplier);

        SupplierResponseDto responseDto = new SupplierResponseDto();

        responseDto.setId(savedSupplier.getId());
        responseDto.setName(savedSupplier.getName());
        responseDto.setEmail(savedSupplier.getEmail());
        responseDto.setPhone(savedSupplier.getPhone());
        responseDto.setAddress(savedSupplier.getAddress());

        return responseDto;
    }

    @Override
    public SupplierResponseDto getSupplierById(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));

        SupplierResponseDto responseDto = new SupplierResponseDto();

        responseDto.setId(supplier.getId());
        responseDto.setName(supplier.getName());
        responseDto.setEmail(supplier.getEmail());
        responseDto.setPhone(supplier.getPhone());
        responseDto.setAddress(supplier.getAddress());

        return responseDto;
    }

    @Override
    public List<SupplierResponseDto> getAllSuppliers() {

        List<Supplier> suppliers = supplierRepository.findAll();

        return suppliers.stream()
                .map(supplier -> {

                    SupplierResponseDto dto = new SupplierResponseDto();

                    dto.setId(supplier.getId());
                    dto.setName(supplier.getName());
                    dto.setEmail(supplier.getEmail());
                    dto.setPhone(supplier.getPhone());
                    dto.setAddress(supplier.getAddress());

                    return dto;

                }).collect(Collectors.toList());
    }

    @Override
    public SupplierResponseDto updateSupplier(Long id,
                                              SupplierRequestDto dto) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));

        supplier.setName(dto.getName());
        supplier.setEmail(dto.getEmail());
        supplier.setPhone(dto.getPhone());
        supplier.setAddress(dto.getAddress());

        Supplier updatedSupplier = supplierRepository.save(supplier);

        SupplierResponseDto responseDto = new SupplierResponseDto();

        responseDto.setId(updatedSupplier.getId());
        responseDto.setName(updatedSupplier.getName());
        responseDto.setEmail(updatedSupplier.getEmail());
        responseDto.setPhone(updatedSupplier.getPhone());
        responseDto.setAddress(updatedSupplier.getAddress());

        return responseDto;
    }

    @Override
    public void deleteSupplier(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));

        supplierRepository.delete(supplier);
    }
}