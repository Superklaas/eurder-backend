package com.switchfully.eurder.api.order_api;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.OrderUnit;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto toDto(Order order) {
        return new OrderDto()
                .setId(order.getId())
                .setOrderUnits(order.getOrderUnits())
                .setUser(order.getUser())
                .setTotalPrice(order.getTotalPrice());
    }
}
