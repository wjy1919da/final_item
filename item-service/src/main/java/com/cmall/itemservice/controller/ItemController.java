package com.cmall.itemservice.controller;

import com.cmall.itemservice.entity.Item;
import com.cmall.itemservice.payload.ItemDto;
import com.cmall.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable String id) {
        return itemService.getItemById(id);
    }
    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody ItemDto itemDto) {
        Item newItem = itemService.addItem(itemDto);
        return ResponseEntity.ok(newItem);
    }

    @GetMapping
    public ResponseEntity<Page<ItemDto>> getAllItems(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "5" ) int size) {
        Pageable pageable = PageRequest.of(page, size);
        System.out.println("Page number: " + pageable.getPageNumber());
        System.out.println("Page size: " + pageable.getPageSize());
        Page<ItemDto> items = itemService.getAllItems(pageable);
        return ResponseEntity.ok(items);
    }
}
