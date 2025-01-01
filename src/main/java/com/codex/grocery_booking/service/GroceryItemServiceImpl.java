package com.codex.grocery_booking.service;

import com.codex.grocery_booking.entity.GroceryItem;
import com.codex.grocery_booking.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemServiceImpl implements GroceryItemService{

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Override
    public GroceryItem addItem(GroceryItem item) {
        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());
        return groceryItemRepository.save(item);
    }

    @Override
    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public Optional<GroceryItem> getItemById(Long id) {
        return groceryItemRepository.findById(id);
    }

    @Override
    public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
        Optional<GroceryItem> existingItem = groceryItemRepository.findById(id);
        if (existingItem.isPresent()) {
            updatedItem.setId(id); // Ensure the ID remains the same
            updatedItem.setUpdatedAt(LocalDateTime.now());
            return groceryItemRepository.save(updatedItem);
        }
        return null; // or throw custom exception
    }

    @Override
    public boolean removeItem(Long id) {
        if (groceryItemRepository.existsById(id)) {
            groceryItemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public GroceryItem updateInventory(Long id, Integer quantity) {
        Optional<GroceryItem> item = groceryItemRepository.findById(id);
        if (item.isPresent()) {
            item.get().setQuantity(quantity);
            return groceryItemRepository.save(item.get());
        }
        return null;
    }

    @Override
    public void deleteItem(Long id) {
        if (groceryItemRepository.existsById(id)) {
            groceryItemRepository.deleteById(id);
        } else {
            throw new RuntimeException("Grocery item not found with id: " + id);
        }

    }
}
