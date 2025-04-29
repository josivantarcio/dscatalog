package com.chipset.dscatalog.service;

import com.chipset.dscatalog.dto.ProductDTO;
import com.chipset.dscatalog.model.Product;
import com.chipset.dscatalog.repository.ProductRepository;
import com.chipset.dscatalog.service.exception.DatabaseException;
import com.chipset.dscatalog.service.exception.ResourceNotFoundException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @Cacheable(value = "products", key = "#id")
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return new ProductDTO(product);
    }

    @Cacheable(value = "products")
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);
        return products.map(ProductDTO::new);
    }

    @CacheEvict(value = "products", allEntries = true)
    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product product = new Product();
        copyDtoToEntity(dto, product);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @CacheEvict(value = "products", allEntries = true)
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product product = repository.getOne(id);
            copyDtoToEntity(dto, product);
            product = repository.save(product);
            return new ProductDTO(product);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Product not found");
        }
    }

    @CacheEvict(value = "products", allEntries = true)
    @Transactional
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Product not found");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "findAllFallback")
    @Transactional(readOnly = true)
    public List<ProductDTO> findByNameContaining(String name) {
        return repository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> findAllFallback(Exception e) {
        return List.of();
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
    }
} 