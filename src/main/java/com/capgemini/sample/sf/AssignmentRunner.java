package com.capgemini.sample.sf;

import com.capgemini.sample.sf.inventory.InventoryFacade;
import com.capgemini.sample.sf.inventory.dto.ItemChangeDto;
import com.capgemini.sample.sf.inventory.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AssignmentRunner {

    public void run(InventoryFacade inventoryFacade) {
        List<ItemDto> allItems = inventoryFacade.getAllItems();
        allItems.forEach(item -> log.info("{}. {} => {}", item.getId(), item.getName(), item.getQuantity()));

        ItemDto pencil = inventoryFacade.getByName("pencil");
        log.info("Info about pencils: {}", pencil);

        ItemChangeDto updateQuantityTo8 = new ItemChangeDto(pencil.getName(), 8);
        inventoryFacade.update(pencil.getId(), updateQuantityTo8);

        ItemChangeDto updateQuantityTo0 = new ItemChangeDto(pencil.getName(), 0);
        inventoryFacade.update(pencil.getId(), updateQuantityTo0);

        List<ItemDto> allItemsAfterChanges = inventoryFacade.getAllItems();
        allItemsAfterChanges.forEach(item -> log.info("{}. {} => {}", item.getId(), item.getName(), item.getQuantity()));
    }

}
