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
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final String ITEM_IMAGE_PATH = "//Users//chanisa/Documents//ICET/clothify_store//item_images//";

    @Autowired
    private ItemRepo itemrepo;

    @PostMapping
    public ResponseEntity<CrudResponses> addItem(@ModelAttribute ItemRequestDTO request) throws IOException {
        request.getImg().transferTo(new File(ITEM_IMAGE_PATH + request.getImg().getOriginalFilename()));

        itemrepo.save(new Item(0,request.getName(),request.getPrice(),request.getLqty(),request.getMqty(),
                        request.getSqty(), request.getImg().getOriginalFilename(), request.getCategory()));

        return ResponseEntity.ok(new CrudResponses(true,"Item Added"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id")int itemID){
        if (itemrepo.findById(itemID).isPresent()){
            return ResponseEntity.ok(itemrepo.findById(itemID).get());
        }
        return ResponseEntity.badRequest().body(new CrudResponses(false,"Item Not Found"));
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){return ResponseEntity.ok(itemrepo.findAll());}


    public ResponseEntity<CrudResponses> updateItem(@PathVariable("id")int itemID,
                                                    @ModelAttribute ItemRequestDTO request) throws IOException {
        if (itemrepo.findById(itemID).isPresent()){
            new File(ITEM_IMAGE_PATH + itemrepo.findById(itemID).get().getImgURL()).delete();
            request.getImg().transferTo(new File(ITEM_IMAGE_PATH + request.getImg().getOriginalFilename()));

            itemrepo.save(new Item(itemID,request.getName(),request.getPrice(),request.getMqty(),request.getLqty(),
                                request.getSqty(), request.getImg().getOriginalFilename(), request.getCategory()));

            return ResponseEntity.ok(new CrudResponses(true,"Item Details Updated"));
        }
        return ResponseEntity.badRequest().body(new CrudResponses(false,"Item Not Found"));
    }

}
