package com.example.GitDemo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    private Integer id;

    private String prName;

    private Double price;

    private Integer quantity;


}
