package com.capgemini.sample.sf;

public class Application {

    public static void main(String[] args) {
        InventoryFacade inventoryFacade = new InventoryFacade();
        new ApplicationRunner().run(inventoryFacade);
    }

}
