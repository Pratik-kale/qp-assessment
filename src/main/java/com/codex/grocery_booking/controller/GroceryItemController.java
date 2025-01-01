package com.codex.grocery_booking.controller;

import com.codex.grocery_booking.entity.GroceryItem;
import com.codex.grocery_booking.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery-items")
public class GroceryItemController {

    @Autowired
    private GroceryItemService groceryItemService;

    // Add a new grocery item
    @PostMapping
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem groceryItem) {
        GroceryItem savedItem = groceryItemService.addItem(groceryItem);
        return ResponseEntity.ok(savedItem);
    }

    // Update an existing grocery item
    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
        GroceryItem updatedItem = groceryItemService.updateItem(id, groceryItem);
        return ResponseEntity.ok(updatedItem);
    }

    // Delete a grocery item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    // View all grocery items
    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        List<GroceryItem> items = groceryItemService.getAllItems();
        return ResponseEntity.ok(items);
    }
}
