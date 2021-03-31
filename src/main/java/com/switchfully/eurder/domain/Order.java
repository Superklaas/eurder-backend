package com.switchfully.eurder.domain;

import java.util.List;
import java.util.UUID;

public class Order {

    private final String id;
    private final List<OrderUnit> orderUnits;
    private final User user;
    private double totalPrice;

    public Order(List<OrderUnit> orderUnits, User user) {
        this.id= UUID.randomUUID().toString();
        this.orderUnits = orderUnits;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public List<OrderUnit> getOrderUnits() {
        return orderUnits;
    }

    public User getUser() {
        return user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

}

