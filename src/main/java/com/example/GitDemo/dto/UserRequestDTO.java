package com.example.GitDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserRequestDTO(String name, String email, Integer age, String city) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.city = city;
    }

    public UserRequestDTO() {
    }

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }*/
}
