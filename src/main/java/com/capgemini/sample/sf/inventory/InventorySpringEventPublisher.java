package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.event.InventoryEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
public class InventorySpringEventPublisher implements InventoryEventPublisher {

    private ApplicationEventPublisher publisher;

    public InventorySpringEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(InventoryEvent event) {
        log.info("Publishing Spring event: {}", event);
        publisher.publishEvent(event);
    }
}
