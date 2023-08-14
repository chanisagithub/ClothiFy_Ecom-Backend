package com.example.clothifyecom.controller;


import com.example.clothifyecom.dto.CrudResponses;
import com.example.clothifyecom.dto.ItemRequestDTO;
import com.example.clothifyecom.entity.Item;
import com.example.clothifyecom.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final String ITEM_IMAGE_PATH = "/Users/chanisa/Documents/ICET/clothify_store/item_images/";

    @Autowired
    private ItemRepo itemrepo;

    @PostMapping
    public ResponseEntity<CrudResponses> addItem(@ModelAttribute ItemRequestDTO request) throws IOException {
        request.getImg().transferTo(new File(ITEM_IMAGE_PATH + request.getImg().getOriginalFilename()));

        itemrepo.save(new Item(0,request.getName(),request.getPrice(),request.getLqty(),request.getMqty(),
                        request.getSqty(), request.getImg().getOriginalFilename(), request.getCategory()));

        return ResponseEntity.ok(new CrudResponses(true,"Item Added"));
    }


}
