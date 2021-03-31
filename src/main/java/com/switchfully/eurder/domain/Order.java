package com.switchfully.eurder.domain;

import java.util.List;
import java.util.UUID;

public class Order {

    private String id;
    private List<OrderUnit> orderUnits;
    private User user;
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

