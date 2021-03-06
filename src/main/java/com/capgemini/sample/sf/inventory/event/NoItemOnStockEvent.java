package com.capgemini.sample.sf.inventory.event;

import com.capgemini.sample.sf.inventory.dto.ItemDto;

public class NoItemOnStockEvent extends InventoryEvent {

    private final ItemDto itemDto;

    public NoItemOnStockEvent(ItemDto itemDto) {
        this.itemDto = itemDto;
    }

    @Override
    public String toString() {
        return "NoItemOnStockEvent{" +
                "itemDto=" + itemDto +
                "} " + super.toString();
    }
}
