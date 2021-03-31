package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

}
