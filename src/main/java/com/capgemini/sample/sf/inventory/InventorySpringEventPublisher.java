package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.event.InventoryEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
// @org.springframework.context.annotation.Primary // example
class InventorySpringEventPublisher implements InventoryEventPublisher {

    private final ApplicationEventPublisher publisher;

    public InventorySpringEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(InventoryEvent event) {
        log.info("Publishing Spring event: {}", event);
        publisher.publishEvent(event);
    }
}
