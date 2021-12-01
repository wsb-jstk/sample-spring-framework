package com.capgemini.sample.sf.infrastructure.controller;

import com.capgemini.sample.sf.inventory.InventoryFacade;
import com.capgemini.sample.sf.inventory.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryFacade inventoryFacade;

    @Autowired
    public InventoryController(InventoryFacade inventoryFacade) {
        this.inventoryFacade = inventoryFacade;
    }

    @GetMapping
    public List<ItemDto> getAll() {
        return inventoryFacade.getAllItems();
    }

    @GetMapping("/all2") // ugly name; do not repeat
    public ResponseEntity<List<ItemDto>> getAllWithDifferentStatusCode() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(inventoryFacade.getAllItems());
    }

}
