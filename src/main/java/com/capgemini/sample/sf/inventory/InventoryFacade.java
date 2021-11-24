package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.infrastructure.Registrator;
import com.capgemini.sample.sf.inventory.dto.ItemChangeDto;
import com.capgemini.sample.sf.inventory.dto.ItemDto;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryFacade {

    private final InventoryRepository repository;
    private final InventoryEventPublisher publisher;

    public InventoryFacade(InventoryRepository repository, InventoryEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public InventoryFacade(Registrator registrator) {
        this.repository = registrator.getObject(InventoryRepository.class);
        this.publisher = registrator.getObject(InventoryEventPublisher.class);
    }

    public List<ItemDto> getAllItems() {
        return repository.findAll()
                .stream()
                .map(item -> item.asDto())
                .collect(Collectors.toList());
    }

    public ItemDto getByName(String name) {
        return repository
                .findByName(name)
                .map(item -> item.asDto())
                .orElseThrow(() -> new ItemNotFoundException(name));
    }

    public void update(long id, ItemChangeDto itemChangeDto) {
        Item item = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        item.update(itemChangeDto);
        repository.save(item);
    }
}
