package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ItemServiceTest {

    Item item;
    ItemRepository itemRepository;
    ItemService itemService;

    @BeforeEach
    void setUp() {
        item = new Item("appel","lekker",2,20);
        itemRepository = mock(ItemRepository.class);
        itemService = new ItemService(itemRepository);
    }

    @Test
    void createItem() {
        when(itemRepository.save(item)).thenReturn(item);
        assertEquals(item, itemService.createItem(item));
    }
}
