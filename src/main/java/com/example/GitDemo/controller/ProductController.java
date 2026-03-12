package com.example.GitDemo.controller;

import com.example.GitDemo.dto.ProductRequestDTO;
import com.example.GitDemo.dto.ProductResponseDTO;
import com.example.GitDemo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController  {


    private final ProductService service;

    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO dto) {
        return service.createProduct(dto);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProduct(@PathVariable Integer id) {
        return service.getProduct(id);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return service.getAllProducts();
    }

    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Integer id,
                                            @Valid @RequestBody ProductRequestDTO dto) {
        return service.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        service.deleteProduct(id);
    }



}
