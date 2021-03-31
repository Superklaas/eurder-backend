package com.switchfully.eurder.domain;

import java.time.LocalDate;
import java.util.UUID;

public class OrderUnit {

    private final String id;
    private final Item item;
    private final int amount;
    private LocalDate shippingDate;

    public OrderUnit(Item item, int amount) {
        this.id= UUID.randomUUID().toString();
        this.item = item;
        this.amount = amount;
    }

    public String getId() {
        return id;
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
