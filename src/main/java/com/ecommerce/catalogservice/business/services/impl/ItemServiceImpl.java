package com.ecommerce.catalogservice.business.services.impl;

import com.ecommerce.catalogservice.business.models.Item;
import com.ecommerce.catalogservice.business.services.ItemService;
import com.ecommerce.catalogservice.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item Create(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> GetItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> GetItemById(String id) {
        return itemRepository.findById(id);
    }

    @Override
    public void DeleteById(String id) {
        itemRepository.deleteById(id);
    }
}
