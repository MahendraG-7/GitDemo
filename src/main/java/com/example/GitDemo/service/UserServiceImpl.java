package com.example.GitDemo.service;

import com.example.GitDemo.dto.UserRequestDTO;
import com.example.GitDemo.dto.UserResponseDTO;
import com.example.GitDemo.entity.User;
import com.example.GitDemo.exception.InvalidUserAgeException;
import com.example.GitDemo.exception.ResourceNotFoundException;
import com.example.GitDemo.exception.UserAlreadyExistsException;
import com.example.GitDemo.mapper.UserMapper;
import com.example.GitDemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository repo;

    private final UserMapper userMapper;


    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
       if(repo.existsByEmail(dto.getEmail())){
           throw new UserAlreadyExistsException("user already exist with email :"+dto.getEmail());
       }
       if(dto.getAge()!=null&& dto.getAge()<=18){
           throw new InvalidUserAgeException("user age must be greater than 18");
       }
        User user = mapToUser(dto);
        User savedUser = repo.save(user);
        return mapToResponse(savedUser);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> userList = repo.findAll();
        return userList.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Integer id) {
        User user = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("user not found with id :" + id));
        return mapToResponse(user);
    }

    @Override
    public UserResponseDTO updateUser(Integer id, UserRequestDTO dto) {

        User existingUser = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with id :" + id));

        if(dto.getAge()!=null && dto.getAge()<=18){
            throw new InvalidUserAgeException("age must be greater than 18");
        }
        if(!existingUser.getEmail().equals(dto.getEmail())
        &&repo.existsByEmail(dto.getEmail())){
            throw new UserAlreadyExistsException("another user already exist by email :"+dto.getEmail());
        }

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());
        existingUser.setAge(dto.getAge());
        existingUser.setCity(dto.getCity());

        User saveUser = repo.save(existingUser);



        return mapToResponse(saveUser);
    }

    @Override
    public UserResponseDTO patchUser(Integer id, UserRequestDTO dto) {
        User user = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with id :" + id));
        System.out.println("User before save: " + user);
        userMapper.updateUserFromDto(dto,user);
        User savedUser = repo.save(user);
        System.out.println("User after save: " + savedUser);
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public String deleteUser(Integer id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with id :" + id));
        repo.delete(user);
return "user deleted successfully";

    }
    private UserResponseDTO mapToResponse(User user) {

        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .city(user.getCity())
                .build();
    }
    private User mapToUser(UserRequestDTO dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .age(dto.getAge())
                .city(dto.getCity())
                .build();
    }
}
