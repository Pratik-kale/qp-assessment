package com.codex.grocery_booking.service;

import com.codex.grocery_booking.entity.OrderDetails;
import com.codex.grocery_booking.entity.OrderItems;
import com.codex.grocery_booking.repository.OrderDetailsRepository;
import com.codex.grocery_booking.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderItemRepository orderItemsRepository;

    @Override
    public OrderDetails createOrder(String userName, List<OrderItems> orderItems) {
        OrderDetails order = new OrderDetails();
        order.setOrderDate(LocalDateTime.now());
        order.setUserName(userName);

        // Save the order details
        OrderDetails savedOrder = orderDetailsRepository.save(order);

        // Save order items for the order
        for (OrderItems item : orderItems) {
            item.setOrderDetails(savedOrder);
            orderItemsRepository.save(item);
        }

        return savedOrder;
    }

    @Override
    public List<OrderDetails> getOrdersByUser(String userName) {
        return orderDetailsRepository.findAll(); //
    }

    @Override
    public Optional<OrderDetails> getOrdersByUserId(Long userId) {
        return orderDetailsRepository.findById(userId);
    }
}
