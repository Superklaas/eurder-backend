package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ItemRepository {

    private final Map<String, Item> itemMap;

    @Autowired
    public ItemRepository(List<Item> itemList) {
        this.itemMap = new HashMap<>();
        if (itemList != null) {
            itemList.stream()
                    .filter(Objects::nonNull)
                    .forEach(item -> itemMap.put(item.getId(), item));
        }
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }
}
