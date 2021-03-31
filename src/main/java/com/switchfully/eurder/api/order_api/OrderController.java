package com.switchfully.eurder.api.order_api;

import com.switchfully.eurder.api.item_api.CreateItemDto;
import com.switchfully.eurder.api.item_api.ItemDto;
import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.OrderUnit;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody List<OrderUnitDto> orderUnitDtoList,
                                @RequestParam String userId) {
        userService.assertRegisteredUser(userId);
        List<OrderUnit> orderUnitList = orderMapper.toOrderUnit(orderUnitDtoList);
        List<OrderUnit> orderUnitListWithShippingDate = orderService.calculateShippingDate(orderUnitList);
        Order order = orderService.createOrder(orderUnitListWithShippingDate);
        return null;
    }

}
