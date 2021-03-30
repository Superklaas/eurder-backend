package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
}
