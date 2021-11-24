package com.capgemini.sample.sf.inventory.dto;

import lombok.Getter;

@Getter
public class ItemDto {

    long id;
    String name;
    int quantity;

    public ItemDto(long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

}
