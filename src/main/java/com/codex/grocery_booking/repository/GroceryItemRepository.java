package com.codex.grocery_booking.repository;

import com.codex.grocery_booking.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}