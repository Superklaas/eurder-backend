package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.*;
import com.switchfully.eurder.dto.Report;
import com.switchfully.eurder.dto.ReportOrder;
import com.switchfully.eurder.dto.ReportOrderUnit;
import com.switchfully.eurder.repository.ItemRepository;
import com.switchfully.eurder.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;
    OrderRepository orderRepository;
    ItemRepository itemRepository;

    Item item;
    User user;
    OrderUnit orderUnit;
    List<OrderUnit> orderUnitList;
    Order order;
    List<Order> ordersByUser;

    List<ReportOrderUnit> reportOrderUnits;
    List<ReportOrder> reportOrders;
    Report report;

    @BeforeEach
    void setUp() {

        orderRepository = mock(OrderRepository.class);
        itemRepository = mock(ItemRepository.class);
        orderService = new OrderService(orderRepository, itemRepository);

        item = new Item("appel", "lekker", 2, 20);

        user = new User("één", "dummy", "abdijstraat 1", "056786543",
                "één@dummy.be", UserType.CUSTOMER);
        orderUnit = new OrderUnit(item, 2);
        orderUnitList = Collections.singletonList(orderUnit);
        order = new Order(orderUnitList, user);
        ordersByUser = List.of(order);

        reportOrderUnits = List.of(new ReportOrderUnit()
                .setNameItem("appel")
                .setAmount(2)
                .setPriceOrderUnit(4));
        reportOrders = List.of(new ReportOrder()
                .setOrderId(order.getId())
                .setReportOrderUnitDtos(reportOrderUnits)
                .setPriceOrder(4));
        report = new Report()
                .setReportOrderDtos(reportOrders)
                .setPriceAllOrders(4);
    }

    @Test
    void calculateShippingDate() {
        List<OrderUnit> orderUnitsWithShippingDate =
                List.of(orderUnit.setShippingDate(LocalDate.now()));
        assertThat(orderService.calculateShippingDate(orderUnitList)).isEqualTo(orderUnitsWithShippingDate);
    }

    @Test
    void createOrder() {
//        when(orderRepository.save(order)).thenReturn(order);
//        assertEquals(order,orderService.createOrder(orderUnitList,user));
    }

    @Test
    void getOrdersByUser() {
        when(orderRepository.getOrdersByUser(user)).thenReturn(ordersByUser);
        assertEquals(ordersByUser, orderService.getOrdersByUser(user));
    }

    @Test
    void makeReport() {
//        assertThat(orderService.makeReport(ordersByUser)).isEqualTo(report);
//        assertEquals(report,orderService.makeReport(ordersByUser));
    }

    @Test
    void getOrderById() {
        String id = order.getId();
        when(orderRepository.getOrderById(id)).thenReturn(order);
        assertThat(orderService.getOrderById(id)).isEqualTo(order);
    }
}
