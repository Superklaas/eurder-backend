package com.switchfully.eurder.dto;

public class ReportOrderUnit {

    private String nameItem;
    private int amount;
    private double priceOrderUnit;

    public String getNameItem() {
        return nameItem;
    }

    public ReportOrderUnit setNameItem(String nameItem) {
        this.nameItem = nameItem;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ReportOrderUnit setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public double getPriceOrderUnit() {
        return priceOrderUnit;
    }

    public ReportOrderUnit setPriceOrderUnit(double priceOrderUnit) {
        this.priceOrderUnit = priceOrderUnit;
        return this;
    }
}
