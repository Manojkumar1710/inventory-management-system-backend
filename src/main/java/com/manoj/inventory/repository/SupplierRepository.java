package com.manoj.inventory.repository;

import com.manoj.inventory.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository
        extends JpaRepository<Supplier, Long> {
}