package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.OrderUnit;
import com.switchfully.eurder.domain.User;
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

    public Order createOrder(List<OrderUnit> orderUnitsWithShippingDate, User user) {
        Order order = new Order(orderUnitsWithShippingDate,user);
        double totalPrice = getTotalPrice(orderUnitsWithShippingDate);
        order.setTotalPrice(totalPrice);
        return order;
    }

    private double getTotalPrice(List<OrderUnit> orderUnitsWithShippingDate) {
        return orderUnitsWithShippingDate.stream()
                .map(unit -> unit.getItem().getPrice()* unit.getAmount())
                .reduce(0.0,Double::sum);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
