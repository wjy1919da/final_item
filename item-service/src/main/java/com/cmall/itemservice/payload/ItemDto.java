package com.cmall.itemservice.payload;

import lombok.Data;

import java.util.Date;

@Data
public class ItemDto {
    private String itemId;
    private String itemName;
    private Double unitPrice;
    private Integer inventoryCount;
    private String category;
    private Date createdAt;
    private Date updatedAt;
}
