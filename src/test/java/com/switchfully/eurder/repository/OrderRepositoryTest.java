package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    Item item;
    User user;
    List<OrderUnit> orderUnitList;
    Order order;
    String id;
    List<Order> orderList;
    OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        item = new Item("appel", "lekker", 2, 20);
        user = new User("één", "dummy", "abdijstraat 1", "056786543",
                "één@dummy.be", UserType.CUSTOMER);
        orderUnitList = List.of(new OrderUnit(item, 2));
        order = new Order(orderUnitList, user);
        id = order.getId();
        orderList = List.of(order);
        orderRepository = new OrderRepository(orderList);
    }

    @Test
    void getOrderMap() {
        Map<String, Order> orderMap = Map.of(id, order);
        assertEquals(orderMap, orderRepository.getOrderMap());
    }

    @Test
    void save() {
        assertEquals(order, orderRepository.save(order));
    }

    @Test
    void getOrdersByUser() {
        assertEquals(orderList, orderRepository.getOrdersByUser(user));
    }
}
