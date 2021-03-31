package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.*;
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

    private final Item item1 = new Item("appel","lekker",2,20);
    private final Item item2 = new Item("peer","lekker",2,20);

    private final OrderUnit orderUnit1 = new OrderUnit(item1,15);
    private final OrderUnit orderUnit2 = new OrderUnit(item2,15);

    private final Order order1 = new Order(List.of(orderUnit1,orderUnit2),user1);

    @Bean
    public List<User> getUsers() {
        return List.of(user1,user2);
    }

    @Bean
    public List<Item> getItems() {
        return List.of(item1,item2);
    }

    @Bean
    public List<Order> getOrders() {
        return List.of(order1);
    }

}
