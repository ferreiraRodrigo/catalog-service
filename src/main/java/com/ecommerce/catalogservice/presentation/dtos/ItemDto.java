package com.ecommerce.catalogservice.presentation.dtos;

import lombok.Data;

@Data
public class ItemDto {
    private String name;
    private String description;
    private double price;
}
