package com.example.clothifyecom.entity;

import com.example.clothifyecom.enums.ItemCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemID;
    private String itemName;
    private double price;
    private int lQTY;
    private int mQTY;
    private int sQTY;
    private String imgURL;
    private ItemCategory category;

}
