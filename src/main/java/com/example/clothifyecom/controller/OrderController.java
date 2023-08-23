package com.example.clothifyecom.controller;


import com.example.clothifyecom.dto.CrudResponses;
import com.example.clothifyecom.entity.Order;
import com.example.clothifyecom.enums.OrderStatustype;
import com.example.clothifyecom.repository.CustomerRepo;
import com.example.clothifyecom.repository.ItemRepo;
import com.example.clothifyecom.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private JavaMailSender javaMailSender;


    @GetMapping("/id")
    public ResponseEntity<?> getOrder(@PathVariable("id")int orderID){
        if(orderRepo.findById(orderID).isPresent()){
            return ResponseEntity.ok(orderRepo.findById(orderID).get());
        }
        return ResponseEntity.ok(new CrudResponses(false,"Order not found"));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderRepo.findAll());
        }

    @GetMapping("/status/{status}")
    public ResponseEntity<?> getOrderByStatus(@PathVariable("status")int status){
        switch (status){
            case 0:
                return ResponseEntity.ok(orderRepo.findByStatus(OrderStatustype.PENDING));
            case 1:
                return ResponseEntity.ok(orderRepo.findByStatus(OrderStatustype.PROCESSING));
            case 2:
                return ResponseEntity.ok(orderRepo.findByStatus(OrderStatustype.DELIVERED));
            case 3:
                return ResponseEntity.ok(orderRepo.findByStatus(OrderStatustype.CANCELLED));
            default:
                return ResponseEntity.badRequest().body(new CrudResponses(false,"Invalid status"));
        }
    }


}
