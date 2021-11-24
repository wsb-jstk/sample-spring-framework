package com.capgemini.sample.sf;

import com.capgemini.sample.sf.inventory.*;

public class Application {

    public static void main(String[] args) {
        InventoryRepository repository = new InMemoryInventoryRepository();
        InventoryEventPublisher publisher = new InventoryLoggingEventPublisher();

        InventoryFacade inventoryFacade = new InventoryFacade(repository, publisher);

        InventorySampleData.initSampleItems(repository);

        new ApplicationRunner().run(inventoryFacade);
    }

}
