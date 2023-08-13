package com.example.clothifyecom.controller;

import com.example.clothifyecom.dto.CrudResponses;
import com.example.clothifyecom.entity.Customer;
import com.example.clothifyecom.repository.CustomerRepo;
import com.example.clothifyecom.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public ResponseEntity<CrudResponses> addCustomer(@RequestBody Customer customer){
        if (userRepo.countByUsername(customer.getUser().getUsername())==0 && userRepo.countByEmail(customer.getUser().getEmail())==0){
            customerRepo.save(customer);

            return ResponseEntity.ok(new CrudResponses(true,"Customer Added"));
        }
        return ResponseEntity.badRequest().body(new CrudResponses(false,"Duplicate User"));
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
