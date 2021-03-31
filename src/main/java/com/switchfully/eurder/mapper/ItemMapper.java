package com.switchfully.eurder.mapper;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.dto.CreateItemDto;
import com.switchfully.eurder.dto.ItemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    public ItemDto toDto(Item item) {
        return new ItemDto()
                .setId(item.getId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(item.getPrice())
                .setStock(item.getStock());
    }

    public List<ItemDto> toDto(List<Item> items) {
        return items.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Item toItem(CreateItemDto dto) {
        return new Item(dto.getName(), dto.getDescription(), dto.getPrice(), dto.getStock());
    }

}
