package com.switchfully.eurder.dto;

import java.util.List;

public class Report {

    private List<ReportOrder> reportOrders;
    private double priceAllOrders;

    public List<ReportOrder> getReportOrderDtos() {
        return reportOrders;
    }

    public Report setReportOrderDtos(List<ReportOrder> reportOrders) {
        this.reportOrders = reportOrders;
        return this;
    }

    public double getPriceAllOrders() {
        return priceAllOrders;
    }

    public Report setPriceAllOrders(double priceAllOrders) {
        this.priceAllOrders = priceAllOrders;
        return this;
    }
}
