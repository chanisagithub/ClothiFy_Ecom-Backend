package com.example.clothifyecom.controller;

import com.example.clothifyecom.entity.Customer;
import com.example.clothifyecom.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerRepo.save(customer);
    }

}
