package com.ecommerce.catalogservice.business.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Item {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;

    private LocalDateTime CreatedAt;
    private LocalDateTime ModifiedAt;
    private LocalDateTime DeletedAt;

    public Item() {
        this.CreatedAt = LocalDateTime.now();
        this.ModifiedAt = LocalDateTime.now();
    }
}
