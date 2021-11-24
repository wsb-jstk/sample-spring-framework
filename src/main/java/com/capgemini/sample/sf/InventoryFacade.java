package com.capgemini.sample.sf;

import com.capgemini.sample.sf.inventory.dto.ItemChangeDto;
import com.capgemini.sample.sf.inventory.dto.ItemDto;

import java.util.List;
import java.util.Optional;

public class InventoryFacade {

    private final InventoryRepository repository;
    private final InventoryEventPublisher publisher;

    public InventoryFacade() {
        repository = new InMemoryInventoryRepository();
        publisher = new InventoryEventPublisher();
    }

    public List<ItemDto> getAllItems() {
        return repository.findAll();
    }

    public Optional<ItemDto> getByName(String name) {
        return repository.findByName(name);
    }

    public void update(long id, ItemChangeDto itemChangeDto) {
        Item item = repository.findById(id);
        item.update(itemChangeDto);
        repository.save(item);
    }
}
