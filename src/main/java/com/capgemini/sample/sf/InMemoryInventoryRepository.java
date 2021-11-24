package com.capgemini.sample.sf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

class InMemoryInventoryRepository implements InventoryRepository {

    private final Map<Long, Item> db = new HashMap<>();
    private final AtomicLong sequencer = new AtomicLong(1);

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Optional<Item> findByName(String name) {
        return null;
    }

    @Override
    public Item findById(long id) {
        return null;
    }

    @Override
    public void save(Item item) {

    }
}
