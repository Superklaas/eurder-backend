package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.OrderUnit;
import com.switchfully.eurder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderUnit> calculateShippingDate(List<OrderUnit> orderUnitList) {
        orderUnitList.forEach(orderUnit -> {
            if (orderUnit.getAmount() <= orderUnit.getItem().getStock()) {
                orderUnit.setShippingDate(LocalDate.now().plusDays(1));
            } else {
                orderUnit.setShippingDate(LocalDate.now().plusDays(7));
            }
        });
        return orderUnitList;
    }

    public Order createOrder(List<OrderUnit> orderUnitListWithShippingDate) {
        return null;
    }
}
