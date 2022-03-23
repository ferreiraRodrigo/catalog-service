package com.ecommerce.catalogservice.repositories;

import com.ecommerce.catalogservice.business.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
