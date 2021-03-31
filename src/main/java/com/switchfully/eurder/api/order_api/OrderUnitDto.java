package com.switchfully.eurder.api.order_api;

import com.switchfully.eurder.domain.Item;

public class OrderUnitDto {

    private Item item;
    private int amount;

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
