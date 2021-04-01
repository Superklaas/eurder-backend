package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.dto.UpdateItemDto;
import com.switchfully.eurder.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ItemServiceTest {

    Item item;
    String id;
    UpdateItemDto dto;
    List<Item> items;
    ItemRepository itemRepository;
    ItemService itemService;

    @BeforeEach
    void setUp() {
        item = new Item("appel","lekker",2,20);
        id = item.getId();
        dto = new UpdateItemDto();
        items = List.of(item);
        itemRepository = mock(ItemRepository.class);
        itemService = new ItemService(itemRepository);
    }

    @Test
    void createItem() {
        when(itemRepository.save(item)).thenReturn(item);
        assertEquals(item, itemService.createItem(item));
    }

    @Test
    void getAllItems() {
        when(itemRepository.findAll()).thenReturn(items);
        assertEquals(items,itemService.getAllItems());
    }

    @Test
    void getItemById() {
        when(itemRepository.findById("1")).thenReturn(item);
        assertEquals(item,itemService.getItemById("1"));
    }

    @Test
    void updateItem() {
        Item updatedItem = itemService.updateItem(item,dto);
        assertAll(
                () -> assertEquals(id,updatedItem.getId()),
                () -> assertNull(updatedItem.getName()),
                () -> assertNull(updatedItem.getDescription()),
                () -> assertEquals(0,updatedItem.getPrice()),
                () -> assertEquals(0,updatedItem.getStock())
        );
    }
}
