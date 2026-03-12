package com.example.GitDemo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    @NotBlank(message="Name is mandatory")
    private String prName;
    @Positive(message ="price should be positive")
    private Double price;
    @Positive(message = "quantity should be positive")
    private Integer quantity;
}
