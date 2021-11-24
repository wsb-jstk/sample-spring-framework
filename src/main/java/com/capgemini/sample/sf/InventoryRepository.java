package com.capgemini.sample.sf;

import java.util.List;
import java.util.Optional;

interface InventoryRepository {
    List<Item> findAll();

    Optional<Item> findByName(String name);

    Optional<Item> findById(long id);

    void save(Item item);
}
