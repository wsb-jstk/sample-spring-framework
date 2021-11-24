package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.dto.ItemChangeDto;
import com.capgemini.sample.sf.inventory.dto.ItemDto;
import com.capgemini.sample.sf.inventory.event.BelowThresholdEvent;
import com.capgemini.sample.sf.inventory.event.NoItemOnStockEvent;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryFacade {

    private static final int STOCK_THRESHOLD = 10;
    private final InventoryRepository repository;
    private final InventoryEventPublisher publisher;

    public InventoryFacade(InventoryRepository repository, InventoryEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
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
        // zacznij liczyc
        Item item = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        item.update(itemChangeDto);
        repository.save(item);

        if (item.getQuantity() == 0) {
            publisher.publish(new NoItemOnStockEvent(item.asDto()));
        } else if (item.getQuantity() <= STOCK_THRESHOLD) {
            publisher.publish(new BelowThresholdEvent(item.asDto(), STOCK_THRESHOLD));
        }
        // skoncz liczyc
        // zwroc wynik
    }
}
