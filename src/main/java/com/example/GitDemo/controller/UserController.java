package com.example.GitDemo.controller;

import com.example.GitDemo.dto.UserRequestDTO;
import com.example.GitDemo.dto.UserResponseDTO;
import com.example.GitDemo.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserServiceImpl userService;

    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> createUser(
            @Valid @RequestBody UserRequestDTO requestDTO) {

        UserResponseDTO response = userService.createUser(requestDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/allUser")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {

        List<UserResponseDTO> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(
            @PathVariable Integer id) {

        UserResponseDTO user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Integer id,
            @Valid @RequestBody UserRequestDTO requestDTO) {

        UserResponseDTO updatedUser =
                userService.updateUser(id, requestDTO);

        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Integer id) {

        userService.deleteUser(id);

        return ResponseEntity.ok("User deleted successfully");
    }


}
