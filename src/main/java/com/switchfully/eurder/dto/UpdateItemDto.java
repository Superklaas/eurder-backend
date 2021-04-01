package com.switchfully.eurder.dto;

public class UpdateItemDto {

    private String name;
    private String description;
    private double price;
    private int stock;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
