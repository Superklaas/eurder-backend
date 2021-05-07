package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.dto.UpdateItemDto;
import com.switchfully.eurder.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(String id) {
        return itemRepository.findById(id);
    }

    public Item updateItem(Item item, UpdateItemDto updateItemDto) {
        return item.setName(updateItemDto.getName())
                .setDescription(updateItemDto.getDescription())
                .setPrice(updateItemDto.getPrice())
                .setStock(updateItemDto.getStock());
    }

    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }
}
