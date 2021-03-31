package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<String, User> userMap;

    @Autowired
    public UserRepository(List<User> userList) {
        this.userMap = new HashMap<>();
        if (userList != null) {
            userList.stream()
                    .filter(Objects::nonNull)
                    .forEach(user -> userMap.put(user.getId(), user));
        }
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public User save(User newCustomer) {
        userMap.put(newCustomer.getId(),newCustomer);
        return newCustomer;
    }

    public User getUserById(String userId) {
        return userMap.get(userId);
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}
