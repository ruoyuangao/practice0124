package com.example.practice0124.service.impl;

import com.example.practice0124.pojo.User;
import com.example.practice0124.pojo.UserDTO;
import com.example.practice0124.pojo.UserResponseDTO;
import com.example.practice0124.repository.UserRepository;
import com.example.practice0124.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    @Transactional
    public long insertUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return this.repository.save(user).getId();
    }

    @Override
    public UserResponseDTO getAllUsers() {
        List<User> userList = this.repository.findAll();

        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userList) {
            userDTOList.add(new UserDTO(user));
        }
        return new UserResponseDTO(userDTOList);
    }
}
