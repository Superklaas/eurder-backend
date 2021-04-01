package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    Item item;
    String id;
    List<Item> itemList;
    ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        item = new Item("appel", "lekker", 2, 20);
        id = item.getId();
        itemList = List.of(item);
        itemRepository = new ItemRepository(itemList);
    }

    @Test
    void constructor_givenItemList_shouldPutItemsInItemMap() {
        assertEquals(item, itemRepository.getItemMap().get(id));
    }

    @Test
    void findById_givenExistingId_shouldReturnItem() {
        assertEquals(item, itemRepository.findById(id));
    }

    @Test
    void findById_givenNonExistingId_throwIllegalArgumentException() {
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> itemRepository.findById("0"));
        assertEquals("404 NOT_FOUND \"Item for id 0 does not exist\"", exception.getMessage());
    }

}
