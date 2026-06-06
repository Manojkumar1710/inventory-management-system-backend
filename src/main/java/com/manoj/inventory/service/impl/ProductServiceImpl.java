package com.manoj.inventory.service.impl;

import com.manoj.inventory.dto.ProductRequestDto;
import com.manoj.inventory.dto.ProductResponseDto;
import com.manoj.inventory.entity.Category;
import com.manoj.inventory.entity.Product;
import com.manoj.inventory.entity.Supplier;
import com.manoj.inventory.exception.ResourceNotFoundException;
import com.manoj.inventory.repository.CategoryRepository;
import com.manoj.inventory.repository.ProductRepository;
import com.manoj.inventory.repository.SupplierRepository;
import com.manoj.inventory.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              SupplierRepository supplierRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));

        Product product = new Product();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        product.setCategory(category);
        product.setSupplier(supplier);

        Product savedProduct = productRepository.save(product);

        ProductResponseDto responseDto = new ProductResponseDto();

        responseDto.setId(savedProduct.getId());
        responseDto.setName(savedProduct.getName());
        responseDto.setDescription(savedProduct.getDescription());
        responseDto.setPrice(savedProduct.getPrice());
        responseDto.setQuantity(savedProduct.getQuantity());

        responseDto.setCategoryName(
                savedProduct.getCategory().getName()
        );

        responseDto.setSupplierName(
                savedProduct.getSupplier().getName()
        );

        return responseDto;
    }

    @Override
    public Page<ProductResponseDto> getProductsPaginated(
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> productPage =
                productRepository.findAll(pageable);

        return productPage.map(product -> {

            ProductResponseDto dto =
                    new ProductResponseDto();

            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setPrice(product.getPrice());
            dto.setQuantity(product.getQuantity());

            dto.setCategoryName(
                    product.getCategory().getName());

            dto.setSupplierName(
                    product.getSupplier().getName());

            return dto;
        });
    }

    @Override
    public List<ProductResponseDto> searchProducts(String name) {

        List<Product> products =
                productRepository.findByNameContaining(name);

        return products.stream()
                .map(product -> {

                    ProductResponseDto dto =
                            new ProductResponseDto();

                    dto.setId(product.getId());
                    dto.setName(product.getName());
                    dto.setDescription(product.getDescription());
                    dto.setPrice(product.getPrice());
                    dto.setQuantity(product.getQuantity());

                    dto.setCategoryName(
                            product.getCategory().getName());

                    dto.setSupplierName(
                            product.getSupplier().getName());

                    return dto;

                }).collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        ProductResponseDto responseDto = new ProductResponseDto();

        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setQuantity(product.getQuantity());

        responseDto.setCategoryName(
                product.getCategory().getName()
        );

        responseDto.setSupplierName(
                product.getSupplier().getName()
        );

        return responseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> {

                    ProductResponseDto dto = new ProductResponseDto();

                    dto.setId(product.getId());
                    dto.setName(product.getName());
                    dto.setDescription(product.getDescription());
                    dto.setPrice(product.getPrice());
                    dto.setQuantity(product.getQuantity());

                    dto.setCategoryName(
                            product.getCategory().getName()
                    );

                    dto.setSupplierName(
                            product.getSupplier().getName()
                    );

                    return dto;

                }).collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto updateProduct(Long id,
                                            ProductRequestDto dto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        product.setCategory(category);
        product.setSupplier(supplier);

        Product updatedProduct = productRepository.save(product);

        ProductResponseDto responseDto = new ProductResponseDto();

        responseDto.setId(updatedProduct.getId());
        responseDto.setName(updatedProduct.getName());
        responseDto.setDescription(updatedProduct.getDescription());
        responseDto.setPrice(updatedProduct.getPrice());
        responseDto.setQuantity(updatedProduct.getQuantity());

        responseDto.setCategoryName(
                updatedProduct.getCategory().getName()
        );

        responseDto.setSupplierName(
                updatedProduct.getSupplier().getName()
        );

        return responseDto;
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        productRepository.delete(product);
    }
}