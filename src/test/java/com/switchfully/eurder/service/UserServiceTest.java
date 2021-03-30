package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.UserType;
import com.switchfully.eurder.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    User user;
    UserRepository userRepository;
    UserService userService;

    @BeforeEach
    void setUp() {
        user = new User("één", "dummy", "abdijstraat 1", "056786543",
                "één@dummy.be", UserType.CUSTOMER);
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

//    @Test
//    void createUser() {
//        when(userRepository.save(user)).thenReturn()
//    }
}
