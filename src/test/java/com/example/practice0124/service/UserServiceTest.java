package com.example.practice0124.service;

import com.example.practice0124.Practice0124Application;
import com.example.practice0124.pojo.User;
import com.example.practice0124.pojo.UserDTO;
import com.example.practice0124.pojo.UserResponseDTO;
import com.example.practice0124.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.practice0124.repository.UserRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository mockrepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

//    Another method
//    @BeforeEach
//    public void init() {
//        this.mockrepository = mock(UserRepository.class);
//        this.userService = new UserServiceImpl(mockrepository);
//    }

    @Test
    public void insertUserWithMNameTest() throws Exception {
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = dateFormat1.parse("1999-06-01");

        User input = new User();
        input.setFirst_name("Amy");
        input.setLast_name("Green");
        input.setMiddle_name("M");
        input.setDob(birthDate);

        User expected = new User();
        expected.setId(1L);
        expected.setFirst_name("Amy");
        expected.setLast_name("Green");
        expected.setMiddle_name("M");
        expected.setDob(birthDate);

        when(this.mockrepository.save(input)).thenReturn(expected);

        UserDTO userDTO = new UserDTO();
        userDTO.setFirst_name("Amy");
        userDTO.setLast_name("Green");
        userDTO.setMiddle_name("M");
        userDTO.setDob(birthDate);
        assertEquals(this.userService.insertUser(userDTO), 1L);
    }

    @Test
    public void insertUserWithoutMNameTest() throws Exception {
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = dateFormat1.parse("1999-06-01");

        User input = new User();
        input.setFirst_name("Amy");
        input.setLast_name("Green");
        input.setDob(birthDate);

        User expected = new User();
        expected.setId(1L);
        expected.setFirst_name("Amy");
        expected.setLast_name("Green");
        expected.setDob(birthDate);

        when(this.mockrepository.save(input)).thenReturn(expected);

        UserDTO userDTO = new UserDTO();
        userDTO.setFirst_name("Amy");
        userDTO.setLast_name("Green");
        userDTO.setDob(birthDate);
        assertEquals(this.userService.insertUser(userDTO), 1L);
    }

}