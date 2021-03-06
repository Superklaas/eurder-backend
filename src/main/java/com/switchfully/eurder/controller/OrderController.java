package com.switchfully.eurder.controller;

import com.switchfully.eurder.dto.OrderDto;
import com.switchfully.eurder.dto.Report;
import com.switchfully.eurder.mapper.OrderMapper;
import com.switchfully.eurder.dto.OrderUnitDto;
import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.OrderUnit;
import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.service.OrderService;
import com.switchfully.eurder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper, UserService userService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody List<OrderUnitDto> orderUnitDtos,
                                @RequestHeader String authToken) {
        User user = userService.assertRegisteredUser(authToken);
        List<OrderUnit> orderUnits = orderService.createOrderUnitFromInput(orderUnitDtos);
        List<OrderUnit> orderUnitsWithShippingDate = orderService.calculateShippingDate(orderUnits);
        Order order = orderService.createOrder(orderUnitsWithShippingDate,user);
        return orderMapper.toDto(order);
    }

    @GetMapping("report")
    @ResponseStatus(HttpStatus.OK)
    public Report reportOrdersForOneUser(@RequestHeader String authToken) {
        User user = userService.assertRegisteredUser(authToken);
        List<Order> ordersByUser = orderService.getOrdersByUser(user);
        return orderService.makeReport(ordersByUser);
    }

    @PostMapping("reorder/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto reorderPreviousOrder(@PathVariable("orderId") String id,
                                         @RequestHeader String authToken) {
        User user = userService.assertRegisteredUser(authToken);
        Order previousOrder = orderService.getOrderById(id);
        orderService.assertOrderMadeByCurrentUser(previousOrder,user);
        List<OrderUnit> orderUnitsWithShippingDate = orderService.calculateShippingDate(previousOrder.getOrderUnits());
        List<OrderUnit> orderUnitsWithShippingDateAndUpdatedPrice =
                orderService.updatePriceItems(orderUnitsWithShippingDate);
        Order newOrder = orderService.createOrder(orderUnitsWithShippingDateAndUpdatedPrice,user);
        return orderMapper.toDto(newOrder);
    }

}
