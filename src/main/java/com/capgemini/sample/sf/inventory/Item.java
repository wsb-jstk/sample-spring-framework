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

    public ItemDto asDto() {
        return new ItemDto(id, name, quantity);
    }

    public void update(ItemChangeDto itemChangeDto) {
        name = itemChangeDto.getNewName();
        quantity = itemChangeDto.getNewQuantity();
    }
}
