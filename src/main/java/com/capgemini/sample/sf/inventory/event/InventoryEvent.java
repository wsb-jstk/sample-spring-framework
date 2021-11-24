package com.capgemini.sample.sf.inventory.event;

import java.time.Instant;

public abstract class InventoryEvent {

    private final Instant createdOn = Instant.now();

    @Override
    public String toString() {
        return "InventoryEvent{" +
                "createdOn=" + createdOn +
                '}';
    }
}
