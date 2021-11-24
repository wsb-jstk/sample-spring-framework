package com.capgemini.sample.sf;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ApplicationRunner {

    public void run(InventoryFacade inventoryFacade) {
        List<Item> allItems = inventoryFacade.getAllItems();
        allItems.stream().foreach(item -> log.info("{}. {} => {}", item.getId(), item.getName(), item.getQuantity()));

        Item pencil = inventoryFacade.getItem("pencil");
        log.info("Info about pencils: {}", pencil);

        UpdateChange updateQuantityTo8 = new UpdateChange(pencil.getName(), 8);
        inventoryFacade.update(updateQuantityTo8);

        UpdateChange updateQuantityTo0 = new UpdateChange(pencil.getName(), 0);
        inventoryFacade.update(updateQuantityTo0);

        List<Item> allItemsAfterChanges = inventoryFacade.getAllItems();
        allItemsAfterChanges.stream().foreach(item -> log.info("{}. {} => {}", item.getId(), item.getName(), item.getQuantity()));
    }

}
