package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.UserType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;

@Configuration
public class DummyData {

    private final User user1 = new User("één","dummy","abdijstraat 1","056786543",
            "één@dummy.be", UserType.CUSTOMER);
    private final User user2 = new User("twee","dummy","abdijstraat 1","056786543",
            "twee@dummy.be", UserType.ADMIN);

    @Bean
    public List<User> getUsers() {
        return List.of(user1,user2);
    }


}
