package com.ecommerce.catalogservice.business.services;

import com.ecommerce.catalogservice.business.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item Create(Item item);
    List<Item> GetItems();
    Optional<Item> GetItemById(String id);
    void DeleteById(String id);
}
