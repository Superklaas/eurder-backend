package com.switchfully.eurder.api.user;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createNewCustomer(@RequestBody CreateUserDto input) {
        User user = userMapper.toUser(input);
        userService.createUser(user);
        return userMapper.toDto(user);
    }



}
