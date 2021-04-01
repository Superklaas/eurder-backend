package com.switchfully.eurder.controller;

import com.switchfully.eurder.dto.CreateUserDto;
import com.switchfully.eurder.dto.UserDto;
import com.switchfully.eurder.mapper.UserMapper;
import com.switchfully.eurder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("createCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createNewCustomer(@RequestBody CreateUserDto input) {
        return userMapper.toDto(userService.createUser(userMapper.toCustomer(input)));
    }

    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers(@RequestHeader String authToken) {
        userService.assertAdmin(authToken);
        return userMapper.toDto(userService.getAllUsers());
    }

    @GetMapping(path = "getById/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable("userId") String id,
                               @RequestHeader String authToken) {
        userService.assertAdmin(authToken);
        return userMapper.toDto(userService.getUserById(id));
    }




}
