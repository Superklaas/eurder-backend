package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private final Map<String, Order> orderMap;

    @Autowired
    public OrderRepository(List<Order> orderList) {
        this.orderMap = new HashMap<>();
        if (orderList != null) {
            orderList.stream()
                    .filter(Objects::nonNull)
                    .forEach(Order -> orderMap.put(Order.getId(), Order));
        }
    }

    public Map<String, Order> getOrderMap() {
        return orderMap;
    }

    public Order save(Order order) {
        orderMap.put(order.getId(), order);
        return order;
    }

    public List<Order> getOrdersByUser(User user) {
        return orderMap.values().stream()
                .filter(order -> order.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public Order getOrderById(String id) {
        return orderMap.get(id);
    }
}
