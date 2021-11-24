package com.capgemini.sample.sf;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

class InMemoryInventoryRepository implements InventoryRepository {

    private final Map<Long, Item> db = new HashMap<>();
    private final AtomicLong sequencer = new AtomicLong(1);

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public Optional<Item> findByName(String name) {
        return db.values()
                .stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<Item> findById(long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public void save(Item item) {
//        Long id = item.getId();
//        if(id == null) {
//            id = sequencer.getAndIncrement();
//            item.setId(id);
//        }
        long id = Optional.ofNullable(item.getId()).orElseGet(() -> generateAndSetId(item));
        db.put(id, item);
    }

    private long generateAndSetId(Item item) {
        long newId = sequencer.getAndIncrement();
        item.setId(newId);
        return newId;
    }
}
