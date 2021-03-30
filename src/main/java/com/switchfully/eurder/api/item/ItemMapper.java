package com.switchfully.eurder.api.item;

import com.switchfully.eurder.domain.Item;
import org.springframework.stereotype.Component;

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

    public Item toItem(CreateItemDto dto) {
        return new Item(dto.getName(), dto.getDescription(), dto.getPrice(), dto.getStock());
    }

}
