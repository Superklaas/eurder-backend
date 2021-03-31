package com.switchfully.eurder.api.order_api;

import com.switchfully.eurder.domain.OrderUnit;
import com.switchfully.eurder.domain.User;

import java.util.List;

public class OrderDto {

    private String id;
    private List<OrderUnit> orderUnits;
    private User user;
    private double totalPrice;

    public String getId() {
        return id;
    }

    public OrderDto setId(String id) {
        this.id = id;
        return this;
    }

    public List<OrderUnit> getOrderUnits() {
        return orderUnits;
    }

    public OrderDto setOrderUnits(List<OrderUnit> orderUnits) {
        this.orderUnits = orderUnits;
        return this;
    }

    public User getUser() {
        return user;
    }

    public OrderDto setUser(User user) {
        this.user = user;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderDto setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
