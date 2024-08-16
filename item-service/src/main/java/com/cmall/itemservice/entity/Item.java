package com.cmall.itemservice.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "items")
public class Item {
    @Id
    private String itemId;

    @Field(name = "itemName")
    private String itemName;

    @Field(name = "unitPrice")
    private Double unitPrice;

    @Field(name = "inventoryCount")
    private Integer inventoryCount;

    @Field(name = "category")
    private String category;

    @CreatedDate
    @Field(name = "createdAt")
    private Date createdAt;

    @LastModifiedDate
    @Field(name = "updatedAt")
    private Date updatedAt;

}
