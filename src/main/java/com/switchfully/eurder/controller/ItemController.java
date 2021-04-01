package com.switchfully.eurder.controller;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.dto.CreateItemDto;
import com.switchfully.eurder.dto.ItemDto;
import com.switchfully.eurder.dto.UpdateItemDto;
import com.switchfully.eurder.mapper.ItemMapper;
import com.switchfully.eurder.service.ItemService;
import com.switchfully.eurder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;
    private final UserService userService;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper, UserService userService) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.userService = userService;
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@RequestBody CreateItemDto input,
                              @RequestHeader String authToken) {
        userService.assertAdmin(authToken);
        return itemMapper.toDto(itemService.createItem(itemMapper.toItem(input)));
    }

    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getAllItems(@RequestHeader String authToken) {
        userService.assertAdmin(authToken);
        return itemMapper.toDto(itemService.getAllItems());
    }

    @PutMapping(path = "update/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto updateItem(@PathVariable("itemId") String id,
                              @RequestBody UpdateItemDto updateItemDto,
                              @RequestHeader String authToken) {
        userService.assertAdmin(authToken);
        Item item = itemService.getItemById(id);
        Item updatedItem = itemService.updateItem(item,updateItemDto);
        return itemMapper.toDto(updatedItem);
    }



}
