package com.example.clothifyecom.controller;

import com.example.clothifyecom.dto.CrudResponses;
import com.example.clothifyecom.entity.Customer;
import com.example.clothifyecom.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){

        return customerRepo.save(customer);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomer(@PathVariable (value = "id")int custID){
        return ResponseEntity.ok(customerRepo.findByCustID(custID));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerRepo.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrudResponses> updateCustomer(@PathVariable ("id")int custID,@RequestBody Customer customer){
        customerRepo.save(customer);
        return ResponseEntity.ok(new CrudResponses(true,"Customer Updated"));
    }
}
