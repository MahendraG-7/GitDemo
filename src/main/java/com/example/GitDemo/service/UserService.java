package com.example.GitDemo.service;

import com.example.GitDemo.dto.UserRequestDTO;
import com.example.GitDemo.dto.UserResponseDTO;
import com.example.GitDemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public interface UserService {

    UserResponseDTO createUser(UserRequestDTO dto);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Integer id);

    UserResponseDTO updateUser(Integer id, UserRequestDTO dto);

    UserResponseDTO patchUser(Integer id, UserRequestDTO dto);

    String deleteUser(Integer id);

}
