package com.switchfully.eurder.api.order_api;

import com.switchfully.eurder.domain.OrderUnit;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderUnit toOrderUnit(OrderUnitDto orderUnitDto) {
        return new OrderUnit(orderUnitDto.getItem(), orderUnitDto.getAmount());
    }

    public List<OrderUnit> toOrderUnit(List<OrderUnitDto> orderUnitDtoList) {
        return orderUnitDtoList.stream().map(this::toOrderUnit).collect(Collectors.toList());
    }

}
