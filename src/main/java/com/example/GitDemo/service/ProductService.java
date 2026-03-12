package com.example.GitDemo.service;

import com.example.GitDemo.dto.ProductRequestDTO;
import com.example.GitDemo.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO dto);

    ProductResponseDTO getProduct(Integer id);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO updateProduct(Integer id, ProductRequestDTO dto);

    void deleteProduct(Integer id);
}
