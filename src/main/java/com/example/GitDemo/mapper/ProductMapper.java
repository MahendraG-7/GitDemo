package com.example.GitDemo.mapper;

import com.example.GitDemo.dto.ProductRequestDTO;
import com.example.GitDemo.dto.ProductResponseDTO;
import com.example.GitDemo.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    Product toEntity(ProductRequestDTO dto);

    ProductResponseDTO toDTO(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromDto(ProductRequestDTO dto, @MappingTarget Product product);
}
