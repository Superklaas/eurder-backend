package com.switchfully.eurder.api.order_api;

import com.switchfully.eurder.domain.Item;

public class OrderUnitDto {

    private String name;
    private int amount;

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
