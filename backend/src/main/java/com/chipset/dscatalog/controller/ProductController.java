package com.chipset.dscatalog.controller;

import com.chipset.dscatalog.dto.ProductDTO;
import com.chipset.dscatalog.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Api(tags = "Product Management")
public class ProductController {

    private final ProductService service;

    @GetMapping
    @ApiOperation(value = "List all products with pagination")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved products"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a product by id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved product"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Product not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search products by name")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved products"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<List<ProductDTO>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(service.findByNameContaining(name));
    }

    @PostMapping
    @ApiOperation(value = "Create a new product")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Product created successfully"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {
        ProductDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a product")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Product updated successfully"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Product not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a product")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Product deleted successfully"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Product not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
} 