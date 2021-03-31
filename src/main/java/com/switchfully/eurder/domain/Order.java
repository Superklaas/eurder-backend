package com.switchfully.eurder.domain;

import java.util.List;

public class Order {

    private List<OrderUnit> orderUnits;
    private User user;
    private double totalPrice;

    public Order(List<OrderUnit> orderUnits, User user) {
        this.orderUnits = orderUnits;
        this.user = user;
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

