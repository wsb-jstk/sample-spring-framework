package com.capgemini.sample.sf.inventory.event;

import com.capgemini.sample.sf.inventory.dto.ItemDto;

public class BelowThresholdEvent extends InventoryEvent {

    private final ItemDto itemDto;
    private final int threshold;

    public BelowThresholdEvent(ItemDto itemDto, int threshold) {
        this.itemDto = itemDto;
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        return "BelowThresholdEvent{" +
                "itemDto=" + itemDto +
                ", threshold=" + threshold +
                "} " + super.toString();
    }
}
