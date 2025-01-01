package com.codex.grocery_booking.controller;

import com.codex.grocery_booking.entity.OrderDetails;
import com.codex.grocery_booking.entity.OrderItems;
import com.codex.grocery_booking.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;


    @PostMapping
    public ResponseEntity<OrderDetails> createOrder(
            @RequestParam String userName,
            @RequestBody List<OrderItems> orderItems) {
        OrderDetails order = orderDetailsService.createOrder(userName, orderItems);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderDetails>> getOrdersByUser(@RequestParam String userName) {
        List<OrderDetails> orders = orderDetailsService.getOrdersByUser(userName);
        return ResponseEntity.ok(orders);
    }

    // Get orders by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<OrderDetails>> getOrdersByUserId(@PathVariable Long userId) {
        Optional<OrderDetails> orders = orderDetailsService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }
}
