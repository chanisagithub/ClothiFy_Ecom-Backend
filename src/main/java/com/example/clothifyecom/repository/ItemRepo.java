package com.example.clothifyecom.repository;

import com.example.clothifyecom.entity.Item;
import com.example.clothifyecom.entity.Order;
import com.example.clothifyecom.enums.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findByCategory(ItemCategory category);
}
