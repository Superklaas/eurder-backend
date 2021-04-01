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
@RequestMapping("/orders")
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

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody List<OrderUnitDto> orderUnitDtos,
                                @RequestHeader String authToken) {
        User user = userService.assertRegisteredUser(authToken);
        List<OrderUnit> orderUnits = orderService.createOrderUnitFromInput(orderUnitDtos);
        List<OrderUnit> orderUnitsWithShippingDate = orderService.calculateShippingDate(orderUnits);
        Order order = orderService.createOrder(orderUnitsWithShippingDate,user);
        return orderMapper.toDto(order);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Report reportOrdersForOneUser(@RequestHeader String authToken) {
        User user = userService.assertRegisteredUser(authToken);
        List<Order> ordersByUser = orderService.getOrdersByUser(user);
        return orderService.makeReport(ordersByUser);
    }

}
