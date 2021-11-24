package com.capgemini.sample.sf;

import com.capgemini.sample.sf.inventory.InventoryFacade;

public class Application {

    public static void main(String[] args) {
        InventoryFacade inventoryFacade = new InventoryFacade();
        new ApplicationRunner().run(inventoryFacade);
    }

}
