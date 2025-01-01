package com.codex.grocery_booking.repository;

import com.codex.grocery_booking.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems, Long> {
}
