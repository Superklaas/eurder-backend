package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    User user;
    List<User> userList;
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        user = new User("één", "dummy", "abdijstraat 1", "056786543",
                "één@dummy.be", UserType.CUSTOMER);
        userList = List.of(user);
        userRepository = new UserRepository(userList);
    }

    @Test
    void constructor_givenUserList_shouldPutUsersInUserMap() {
        assertEquals(user, userRepository.getUserMap().get(user.getId()));
    }

}
