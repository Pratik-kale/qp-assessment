package com.codex.grocery_booking.service;

import com.codex.grocery_booking.entity.OrderDetails;
import com.codex.grocery_booking.entity.OrderItems;

import java.util.List;
import java.util.Optional;

public interface OrderDetailsService {

    OrderDetails createOrder(String userName, List<OrderItems> orderItems);

    List<OrderDetails> getOrdersByUser(String userName);

    Optional<OrderDetails> getOrdersByUserId(Long userId);
}
