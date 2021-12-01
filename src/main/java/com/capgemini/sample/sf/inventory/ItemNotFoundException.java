package com.capgemini.sample.sf.inventory;

class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String name) {
        super("Item with name " + name + " does not exist");
    }

    public ItemNotFoundException(long id) {
        super("Item with id " + id + " does not exist");
    }
}
