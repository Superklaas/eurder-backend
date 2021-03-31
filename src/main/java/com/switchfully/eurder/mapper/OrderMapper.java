package com.switchfully.eurder.mapper;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.dto.OrderDto;
import org.springframework.stereotype.Component;

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
