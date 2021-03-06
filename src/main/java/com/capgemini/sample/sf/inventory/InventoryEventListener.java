package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.event.BelowThresholdEvent;
import com.capgemini.sample.sf.inventory.event.InventoryEvent;
import com.capgemini.sample.sf.inventory.event.NoItemOnStockEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Example how to use {@link EventListener}
 */
@Slf4j
@Component
class InventoryEventListener {

    @EventListener
    public void onAllEvents(InventoryEvent event) {
        log.info("Got event: {}", event);
    }

    @EventListener
    public void onBelow10Listener(BelowThresholdEvent event) {
        log.info("Got below-threshold-event: {}", event);
    }

    @EventListener
    public void onNoStockListener(NoItemOnStockEvent event) {
        log.info("Got no-item-event: {}", event);
    }

}
