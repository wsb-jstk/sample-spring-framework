package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.infrastructure.aspect.LogInputArguments;
import com.capgemini.sample.sf.infrastructure.aspect.MeasureTime;
import com.capgemini.sample.sf.inventory.dto.ItemChangeDto;
import com.capgemini.sample.sf.inventory.dto.ItemDto;
import com.capgemini.sample.sf.inventory.event.BelowThresholdEvent;
import com.capgemini.sample.sf.inventory.event.NoItemOnStockEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InventoryFacade {

    private static final int STOCK_THRESHOLD = 10;
    private InventoryRepository repository;
    private InventoryEventPublisher publisher;

    @Autowired // leaving @Autowired as example (it's not required)
    public InventoryFacade(InventoryRepository repository
            , @Qualifier("inventorySpringEventPublisher") InventoryEventPublisher publisher
                           // , @Qualifier("inventoryLoggingEventPublisher") InventoryEventPublisher publisher
    ) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public List<ItemDto> getAllItems() {
        return repository.findAll()
                .stream()
                .map(Item::asDto) // .map(item -> item.asDto())
                .collect(Collectors.toList());
    }

    public ItemDto getByName(String name) {
        return repository
                .findByName(name)
                .map(Item::asDto) // .map(item -> item.asDto())
                .orElseThrow(() -> new ItemNotFoundException(name));
    }

    public ItemDto getById(long id) {
        return repository
                .findById(id)
                .map(Item::asDto) // .map(item -> item.asDto())
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @MeasureTime
    @LogInputArguments
    public void update(long id, ItemChangeDto itemChangeDto) {
        Item item = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        item.update(itemChangeDto);
        repository.save(item);

        if (item.getQuantity() == 0) {
            publisher.publish(new NoItemOnStockEvent(item.asDto()));
        } else if (item.getQuantity() <= STOCK_THRESHOLD) {
            publisher.publish(new BelowThresholdEvent(item.asDto(), STOCK_THRESHOLD));
        }
    }
}
