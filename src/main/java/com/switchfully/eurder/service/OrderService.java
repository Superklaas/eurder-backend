package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.OrderUnitDto;
import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.OrderUnit;
import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.dto.Report;
import com.switchfully.eurder.dto.ReportOrder;
import com.switchfully.eurder.dto.ReportOrderUnit;
import com.switchfully.eurder.repository.ItemRepository;
import com.switchfully.eurder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    ItemRepository itemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public List<OrderUnit> calculateShippingDate(List<OrderUnit> orderUnitList) {
        orderUnitList.forEach(orderUnit -> {
            if (orderUnit.getAmount() <= orderUnit.getItem().getStock()) {
                orderUnit.setShippingDate(LocalDate.now().plusDays(1));
            } else {
                orderUnit.setShippingDate(LocalDate.now().plusDays(7));
            }
        });
        return orderUnitList;
    }

    public Order createOrder(List<OrderUnit> orderUnitsWithShippingDate, User user) {
        Order order = new Order(orderUnitsWithShippingDate, user);
        double totalPrice = calculatePriceOrder(orderUnitsWithShippingDate);
        order.setTotalPrice(totalPrice);
        return orderRepository.save(order);
    }

    public List<OrderUnit> createOrderUnitFromInput(List<OrderUnitDto> orderUnitDtos) {
        List<OrderUnit> orderUnits = new ArrayList<>();
        for (OrderUnitDto orderUnitDto : orderUnitDtos) {
            Item item = itemRepository.getItemByName(orderUnitDto.getName());
            OrderUnit orderUnit = new OrderUnit(item, orderUnitDto.getAmount());
            orderUnits.add(orderUnit);
        }
        return orderUnits;
    }

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.getOrdersByUser(user);
    }

    public Report makeReport(List<Order> ordersByUser) {
        Report report = new Report();
        List<ReportOrder> reportOrders = new ArrayList<>();
        for (Order order : ordersByUser) {
            ReportOrder reportOrder = new ReportOrder();
            reportOrder.setOrderId(order.getId());
            List<ReportOrderUnit> reportOrderUnits = new ArrayList<>();
            for (OrderUnit orderUnit : order.getOrderUnits()) {
                ReportOrderUnit reportOrderUnit = new ReportOrderUnit();
                reportOrderUnit.setNameItem(orderUnit.getItem().getName());
                reportOrderUnit.setAmount(orderUnit.getAmount());
                reportOrderUnit.setPriceOrderUnit(calculatePriceOrderUnit(orderUnit));
                reportOrderUnits.add(reportOrderUnit);
            }
            reportOrder.setReportOrderUnitDtos(reportOrderUnits);
            reportOrder.setPriceOrder(calculatePriceOrder(order.getOrderUnits()));
            reportOrders.add(reportOrder);
        }
        report.setReportOrderDtos(reportOrders);
        report.setPriceAllOrders(calculatePriceAllOrders(ordersByUser));
        return report;
    }

    private double calculatePriceOrderUnit(OrderUnit orderUnit) {
        return orderUnit.getItem().getPrice() * orderUnit.getAmount();
    }

    private double calculatePriceOrder(List<OrderUnit> orderUnits) {
        return orderUnits.stream()
                .map(this::calculatePriceOrderUnit)
                .reduce(0.0, Double::sum);
    }

    private double calculatePriceAllOrders(List<Order> orders) {
        return orders.stream()
                .map(order -> calculatePriceOrder(order.getOrderUnits()))
                .reduce(0.0, Double::sum);
    }

}
