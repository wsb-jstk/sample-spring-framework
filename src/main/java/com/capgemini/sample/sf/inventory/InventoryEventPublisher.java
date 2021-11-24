package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.event.InventoryEvent;

public interface InventoryEventPublisher {

    void publish(InventoryEvent event);

}
