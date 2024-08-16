package com.cmall.itemservice.service;

import com.cmall.itemservice.entity.Item;
import com.cmall.itemservice.payload.ItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    public ItemDto getItemById(String id);
    Item addItem(ItemDto itemDto);
    Page<ItemDto> getAllItems(Pageable pageable);
}
