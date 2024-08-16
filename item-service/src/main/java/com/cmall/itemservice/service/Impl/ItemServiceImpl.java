package com.cmall.itemservice.service.Impl;

import com.cmall.itemservice.dao.ItemRepository;
import com.cmall.itemservice.entity.Item;
import com.cmall.itemservice.payload.ItemDto;
import com.cmall.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDto getItemById(String id){
        return itemRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Item not found!"));
    }

    @Override
    public Page<ItemDto> getAllItems(Pageable pageable) {
        return itemRepository.findAll(pageable).map(this::convertToDto);
    }

    @Override
    public Item addItem(ItemDto itemDto) {
        Item item = new Item();
        item.setItemName(itemDto.getItemName());
        item.setUnitPrice(itemDto.getUnitPrice());
        item.setInventoryCount(itemDto.getInventoryCount());
        item.setCategory(itemDto.getCategory());
        item.setCreatedAt(new Date());  // Manually setting creation date
        item.setUpdatedAt(new Date());  // Manually setting update date
        return itemRepository.save(item);
    }

    private ItemDto convertToDto(Item item) {
        ItemDto dto = new ItemDto();
        dto.setItemId(item.getItemId());
        dto.setItemName(item.getItemName());
        dto.setUnitPrice(item.getUnitPrice());
        dto.setInventoryCount(item.getInventoryCount());
        dto.setCategory(item.getCategory());
        dto.setCreatedAt(item.getCreatedAt());
        dto.setUpdatedAt(item.getUpdatedAt());
        return dto;
    }
}
