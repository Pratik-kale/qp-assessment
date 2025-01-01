package com.codex.grocery_booking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderDetails orderDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private GroceryItem groceryItem;

    @Column(nullable = false)
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public GroceryItem getGroceryItem() {
        return groceryItem;
    }

    public void setGroceryItem(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderItems(Long id, OrderDetails orderDetails, GroceryItem groceryItem, Integer quantity) {
        this.id = id;
        this.orderDetails = orderDetails;
        this.groceryItem = groceryItem;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "id=" + id +
                ", orderDetails=" + orderDetails +
                ", groceryItem=" + groceryItem +
                ", quantity=" + quantity +
                '}';
    }
}
