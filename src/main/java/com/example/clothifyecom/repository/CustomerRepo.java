package com.example.clothifyecom.repository;

import com.example.clothifyecom.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findByCustID(int custID);
}
