package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createUser(User newCustomer) {
        return userRepository.save(newCustomer);
    }

    public User assertRegisteredUser(String userId) {
        User user = userRepository.getUserById(userId);
        if(user == null) {
            throw new IllegalArgumentException("User does not exist in map");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
