package com.example.practice0124.controller;

import com.example.practice0124.pojo.UserDTO;
import com.example.practice0124.pojo.UserRequestDTO;
import com.example.practice0124.pojo.UserResponseDTO;
import com.example.practice0124.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userinfo")
public class UserController {

    private final UserService service;
    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @PostMapping
    public ResponseEntity<Long> insertUser(@RequestBody UserRequestDTO userRequestDTO) {
        long id = this.service.insertUser(userRequestDTO.getProvider());
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<UserResponseDTO> getAllUsers() {
        return new ResponseEntity<>(this.service.getAllUsers(), HttpStatus.OK);
    }

}
