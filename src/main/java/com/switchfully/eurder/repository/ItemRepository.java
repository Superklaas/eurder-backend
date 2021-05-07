package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

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

    public Item save(Item item) {
        itemMap.put(item.getId(),item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(itemMap.values());
    }

    public Item getItemByName(String name) {
        return itemMap.values().stream()
                .filter(item -> item.getName().equals(name))
                .findAny().orElseThrow();
    }

    public Item findById(String id) {
        if (itemMap.get(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Item for id "+id+" does not exist");
        }
        return itemMap.get(id);
    }

    public void delete(Item item) {
        itemMap.remove(item.getId());
    }
}
