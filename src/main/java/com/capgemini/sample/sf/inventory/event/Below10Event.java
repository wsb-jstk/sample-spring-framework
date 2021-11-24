package com.capgemini.sample.sf.inventory.event;

import com.capgemini.sample.sf.inventory.dto.ItemDto;

public class Below10Event extends InventoryEvent {

    private final ItemDto itemDto;
    private final int threshold;

    public Below10Event(ItemDto itemDto, int threshold) {
        this.itemDto = itemDto;
        this.threshold = threshold;
    }

}
