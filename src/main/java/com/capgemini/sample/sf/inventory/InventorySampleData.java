package com.capgemini.sample.sf.inventory;

import com.capgemini.sample.sf.inventory.dto.ItemDto;

import java.util.Arrays;
import java.util.List;

public final class InventorySampleData {

    private InventorySampleData() {
    }

    private static List<ItemDto> sampleItems() {
        return Arrays.asList(new ItemDto("A", 10),
                new ItemDto("B", 20),
                new ItemDto("C", 30),
                new ItemDto("D", 40),
                new ItemDto("E", 50),
                new ItemDto("F", 60),
                new ItemDto("G", 70),
                new ItemDto("pencil", 80));
    }

    public static void initSampleItems(InventoryRepository repository) {
        sampleItems().stream()
                .map(Item::fromDto)
                .forEach(repository::save);
    }

}
