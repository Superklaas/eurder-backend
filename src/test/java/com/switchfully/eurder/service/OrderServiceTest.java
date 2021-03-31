package com.switchfully.eurder.service;

import com.switchfully.eurder.repository.ItemRepository;
import com.switchfully.eurder.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    OrderService orderService;
    OrderRepository orderRepository;
    ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        itemRepository = mock(ItemRepository.class);
        orderService = new OrderService(orderRepository,itemRepository);
    }

    @Test
    void calculateShippingDate() {
    }

    @Test
    void createOrder() {
    }
}
