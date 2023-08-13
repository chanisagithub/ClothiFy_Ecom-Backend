package com.example.clothifyecom.controller;

import com.example.clothifyecom.dto.CrudResponses;
import com.example.clothifyecom.entity.Customer;
import com.example.clothifyecom.enums.UserRole;
import com.example.clothifyecom.repository.CustomerRepo;
import com.example.clothifyecom.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public ResponseEntity<CrudResponses> addCustomer(@RequestBody Customer customer){
        if (userRepo.existsByEmail(customer.getUser().getEmail())){

            return ResponseEntity.badRequest().body(new CrudResponses(false,"Duplicate Data"));
        }
        customer.getUser().setRole(UserRole.CUSTOMER_ROLE);
        customerRepo.save(customer);
        return ResponseEntity.badRequest().body(new CrudResponses(false,"Duplicate User"));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomer(@PathVariable ("id")int custID){
        if (customerRepo.existsById(custID)){
            return ResponseEntity.ok(customerRepo.findByCustID(custID));
        }
        return ResponseEntity.badRequest().body(new CrudResponses(false,"Customer not found"));
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

    public ResponseEntity<CrudResponses> deleteCustomer(@PathVariable ("id")int custID){
        if (customerRepo.existsById(custID)){
            customerRepo.deleteById(custID);
            return ResponseEntity.ok(new CrudResponses(true,"Customer Deleted"));
        }
        return ResponseEntity.badRequest().body(new CrudResponses(false,"Customer not found"));
    }
}
