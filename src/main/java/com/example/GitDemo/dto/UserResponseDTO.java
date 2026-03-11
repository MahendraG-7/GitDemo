package com.example.GitDemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {

    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String city;
}
