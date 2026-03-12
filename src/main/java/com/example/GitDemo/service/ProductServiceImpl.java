package com.example.GitDemo.service;

import com.example.GitDemo.dto.ProductRequestDTO;
import com.example.GitDemo.dto.ProductResponseDTO;
import com.example.GitDemo.entity.Product;
import com.example.GitDemo.exception.ResourceNotFoundException;
import com.example.GitDemo.mapper.ProductMapper;
import com.example.GitDemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;
    private final ProductMapper mapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        log.info("creating product : {}",dto.getPrName());
        Product product = mapper.toEntity(dto);
        product = repo.save(product);
        

        return mapper.toDTO(product);
    }

    @Override
    public ProductResponseDTO getProduct(Integer id) {
        log.info("Fetching product with id {}", id);
        Product product = repo.findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException("product not found with id :" + id));
        return mapper.toDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO updateProduct(Integer id, ProductRequestDTO dto) {
        Product product = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id));

        mapper.updateProductFromDto(dto, product);

        repo.save(product);

        return mapper.toDTO(product);
    }

    @Override
    public void deleteProduct(Integer id) {

        Product product = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id));

        repo.delete(product);
    }
}
