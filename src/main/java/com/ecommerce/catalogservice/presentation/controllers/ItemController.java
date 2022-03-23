package com.ecommerce.catalogservice.presentation.controllers;

import com.ecommerce.catalogservice.business.models.Item;
import com.ecommerce.catalogservice.business.services.ItemService;
import com.ecommerce.catalogservice.configuration.Configuration;
import com.ecommerce.catalogservice.presentation.dtos.ItemDto;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private Configuration configuration;
    @Autowired
    private ItemService itemService;

    @GetMapping("/mock")
    public String mockUpResult() {
        return "This is a mock up result." + configuration.getMockValue();
    }

    @PostMapping
    public ResponseEntity<Object> createItem(@RequestBody ItemDto itemDto) {
        var item = new Item();
        BeanUtils.copyProperties(itemDto, item);

        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.Create(item));
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.GetItems());
    }

    @GetMapping("/id")
    public ResponseEntity<Object> getItemById(@PathVariable(value = "id") String id) {
        var item = itemService.GetItemById(id);

        if (item.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The item was not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(item.get());
    }

    @DeleteMapping("/id")
    public ResponseEntity<Object> deleteItemById(@PathVariable(value = "id") String id) {
        var item = itemService.GetItemById(id);

        if (item.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The item was not found.");
        }

        itemService.DeleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("The item was deleted successfully.");
    }

}
