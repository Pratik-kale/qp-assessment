package com.codex.grocery_booking.service;

import com.codex.grocery_booking.entity.GroceryItem;

import java.util.List;
import java.util.Optional;

public interface GroceryItemService {

    GroceryItem addItem(GroceryItem item);

    List<GroceryItem> getAllItems();

    Optional<GroceryItem> getItemById(Long id);

    GroceryItem updateItem(Long id, GroceryItem updatedItem);

    boolean removeItem(Long id);

    GroceryItem updateInventory(Long id, Integer quantity);

    void deleteItem(Long id);
}
