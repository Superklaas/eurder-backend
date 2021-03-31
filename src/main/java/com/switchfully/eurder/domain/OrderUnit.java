package com.switchfully.eurder.domain;

import java.time.LocalDate;

public class OrderUnit {

    private final Item item;
    private final int amount;
    private LocalDate shippingDate;

    public OrderUnit(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public OrderUnit setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }
}
