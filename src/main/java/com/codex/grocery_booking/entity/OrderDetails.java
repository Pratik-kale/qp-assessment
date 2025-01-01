package com.codex.grocery_booking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "user_name", nullable = false)
    private String userName;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OrderDetails(Long id, LocalDateTime orderDate, String userName) {
        this.id = id;
        this.orderDate = orderDate;
        this.userName = userName;
    }

    public OrderDetails() {
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", userName='" + userName + '\'' +
                '}';
    }


}
