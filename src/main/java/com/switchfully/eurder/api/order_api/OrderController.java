package com.switchfully.eurder.api.order_api;

import com.switchfully.eurder.api.item_api.CreateItemDto;
import com.switchfully.eurder.api.item_api.ItemDto;
import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.OrderUnit;
import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.service.OrderService;
import com.switchfully.eurder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping(consumes="application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody List<OrderUnitDto> orderUnitDtos,
                                @RequestParam String userId) {
        User user = userService.assertRegisteredUser(userId);
        List<OrderUnit> orderUnits = orderMapper.toOrderUnit(orderUnitDtos);
        List<OrderUnit> orderUnitsWithShippingDate = orderService.calculateShippingDate(orderUnits);
        Order order = orderService.createOrder(orderUnitsWithShippingDate,user);
        return orderMapper.toDto(order);
    }

}
