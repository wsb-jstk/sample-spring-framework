package com.capgemini.sample.sf.inventory.dto;

import lombok.Value;

@Value
public class ItemChangeDto {
    String newName;
    int newQuantity;
}
