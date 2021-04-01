package com.switchfully.eurder.dto;

import java.util.List;

public class ReportOrder {

    private String orderId;
    private List<ReportOrderUnit> reportOrderUnits;
    private double priceOrder;

    public String getOrderId() {
        return orderId;
    }

    public ReportOrder setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public List<ReportOrderUnit> getReportOrderUnitDtos() {
        return reportOrderUnits;
    }

    public ReportOrder setReportOrderUnitDtos(List<ReportOrderUnit> reportOrderUnits) {
        this.reportOrderUnits = reportOrderUnits;
        return this;
    }

    public double getPriceOrder() {
        return priceOrder;
    }

    public ReportOrder setPriceOrder(double priceOrder) {
        this.priceOrder = priceOrder;
        return this;
    }
}
