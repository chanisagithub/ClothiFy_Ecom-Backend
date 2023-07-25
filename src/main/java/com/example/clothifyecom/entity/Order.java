package com.example.clothifyecom.entity;

import com.example.clothifyecom.enums.OrderStatustype;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cust_order")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    private OrderStatustype status;
    private String cust_Address;
    private String cust_Name;
    private String cust_mobile;
    private String orderDateTime;
    private int custID;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    private List<OrderDetail> orderDetails;

}
