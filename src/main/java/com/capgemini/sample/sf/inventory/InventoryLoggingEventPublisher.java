package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.event.InventoryEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class InventoryLoggingEventPublisher implements InventoryEventPublisher {

    @Override
    public void publish(InventoryEvent event) {
        log.info("Publishing event: {}", event);
    }
}
