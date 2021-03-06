package com.capgemini.sample.sf.inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository {
    List<Item> findAll();

    Optional<Item> findByName(String name);

    Optional<Item> findById(long id);

    void save(Item item);
}
