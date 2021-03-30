package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    Item item;
    List<Item> itemList;
    ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        item = new Item("appel","lekker",2,20);
        itemList = List.of(item);
        itemRepository = new ItemRepository(itemList);
    }

    @Test
    void constructor_givenItemList_shouldPutItemsInItemMap() {
        assertEquals(item, itemRepository.getItemMap().get(item.getId()));
    }


}
