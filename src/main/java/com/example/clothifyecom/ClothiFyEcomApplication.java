package com.example.clothifyecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClothiFyEcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothiFyEcomApplication.class, args);
    }

    @GetMapping
    public String display(){
        return "Clothify Store";
    }

}
