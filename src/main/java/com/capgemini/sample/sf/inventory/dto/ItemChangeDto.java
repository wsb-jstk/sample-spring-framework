package com.capgemini.sample.sf.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link NoArgsConstructor} is required by Jackson to avoid error: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.capgemini.sample.sf.inventory.dto.ItemChangeDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemChangeDto {
    String newName;
    int newQuantity;
}
