package com.example.clothifyecom.repository;

import com.example.clothifyecom.entity.Order;
import com.example.clothifyecom.enums.OrderStatustype;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    List<Order> findByStatus(OrderStatustype status);
    List<Order> findByCustID(int custID);
}
