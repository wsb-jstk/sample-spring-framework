package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.dto.ItemChangeDto;
import com.capgemini.sample.sf.inventory.dto.ItemDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Item {

    Long id;
    String name;
    int quantity;
//    Instant createdOn;
//    String createdBy;

    private Item(Long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public static Item fromDto(ItemDto itemDto) {
        return new Item(null, itemDto.getName(), itemDto.getQuantity());
    }

    public ItemDto asDto() {
        return new ItemDto(id, name, quantity);
    }

    public void update(ItemChangeDto itemChangeDto) {
        name = itemChangeDto.getNewName();
        quantity = itemChangeDto.getNewQuantity();
    }
}
