package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.event.InventoryEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryLoggingEventPublisher implements InventoryEventPublisher {

    @Override
    public void publish(InventoryEvent event) {
        log.info("Publishing event: {}", event);
    }
}
