package com.example.clothifyecom.controller;

import com.example.clothifyecom.entity.Customer;
import com.example.clothifyecom.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerRepo.save(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable (value = "id")int custID){
        return customerRepo.findByCustID(custID);
    }

}
