package com.example.GitDemo.mapper;

import com.example.GitDemo.dto.UserRequestDTO;
import com.example.GitDemo.dto.UserResponseDTO;
import com.example.GitDemo.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDTO dto);
    UserResponseDTO toResponseDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserRequestDTO dto, @MappingTarget User user);


}
