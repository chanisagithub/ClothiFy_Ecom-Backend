package com.example.clothifyecom.controller;


import com.example.clothifyecom.entity.Item;
import com.example.clothifyecom.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepo itemrepo;

    @PostMapping
    public Item addItem(@RequestBody Item item){
        return itemrepo.save(item);

    }
}
