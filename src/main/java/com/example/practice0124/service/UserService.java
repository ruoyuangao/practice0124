package com.example.practice0124.service;

import com.example.practice0124.pojo.UserDTO;
import com.example.practice0124.pojo.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public long insertUser(UserDTO userDTO);

    public UserResponseDTO getAllUsers();
}
