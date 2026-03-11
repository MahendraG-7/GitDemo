package com.example.GitDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class UserRequestDTO {

    @NotBlank(message="Name is mandatory")
    private String name;

    @Email(message="Invalid email format")
    @NotBlank(message="Email is mandatory")
    private String email;

    @Min(value=18,message="Age must be greater than 18")
    private Integer age;
    @NotBlank(message="city is mandatory")
    private String city;

}
